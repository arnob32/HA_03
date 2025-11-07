package airportSmartLuggageManagementSystem;

import java.util.concurrent.*;
import java.util.*;
import java.time.*;

public class QueueManage {
    private final int stations;                    
    private final ExecutorService chargers; 
    private final BlockingQueue<AGV> waitQueue = new LinkedBlockingQueue<>();
    private final LogManager log;
    private final long SIM_MINUTE_MS = 200;
    private final long MAX_WAIT_MS  = 15 * SIM_MINUTE_MS;

    private final Map<Integer, Long> arrivalTimes = new ConcurrentHashMap<>();
    private volatile boolean running = true;

    public QueueManage(int stations, LogManager log) {
        this.stations = stations;
        this.log = log;
        this.chargers = Executors.newFixedThreadPool(stations);
        startDispatcher();
    }

    public void requestCharge(AGV agv) {
        arrivalTimes.put(agv.getId(), System.currentTimeMillis());
        waitQueue.offer(agv);
        log.writeLog("charging", "charger_pool", "AGV " + agv.getId() + " joined queue");
    }

    private void startDispatcher() {
        // Dispatcher thread continually assigns from queue to free charger workers
        Thread dispatcher = new Thread(() -> {
            while (running) {
                try {
                    AGV agv = waitQueue.take(); // next in queue
                    long waited = System.currentTimeMillis() -
                            arrivalTimes.getOrDefault(agv.getId(), System.currentTimeMillis());
                    if (waited > MAX_WAIT_MS) {
                        log.writeLog("charging", "charger_pool",
                                "AGV " + agv.getId() + " left queue (wait " + waited + " ms)");
                        continue;
                    }
                    chargers.submit(() -> doCharge(agv));
                } catch (InterruptedException ignored) { }
            }
        });
        dispatcher.setDaemon(true);
        dispatcher.start();
    }

    private void doCharge(AGV agv) {
        try {
            log.writeLog("charging", "charger_pool",
                    "Charging START for AGV " + agv.getId());
          
            Thread.sleep(20 * SIM_MINUTE_MS);
            agv.setBattery(100);
            log.writeLog("charging", "charger_pool",
                    "Charging END for AGV " + agv.getId());
        } catch (InterruptedException ignored) { }
    }

    public void shutdown() {
        running = false;
        chargers.shutdownNow();
    }
}

