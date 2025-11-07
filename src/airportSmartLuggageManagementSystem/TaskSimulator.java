package airportSmartLuggageManagementSystem;

import java.util.*;
import java.util.concurrent.*;

public class TaskSimulator {
    private final int M; // total tasks
    private final int K; // available AGVs
    private final LogService log;
    private final chargingQueue chargingQueue;
    private final ExecutorService agvPool;
    private final List<AGV> agvs = new ArrayList<>();
    private final Random rnd = new Random();

    public TaskSimulator(int M, int K, LogService log, chargingQueue cq) {
        this.M = M; this.K = K; this.log = log; this.chargingQueue = cq;
        this.agvPool = Executors.newFixedThreadPool(K);
        for (int i = 1; i <= K; i++) agvs.add(new AGV(i));
    }

    public void runSimulation() {
        log.writeRecord("Simulation started: " + M + " tasks, " + K + " AGVs");
        for (int t = 1; t <= M; t++) {
            final int taskId = t;
            agvPool.submit(() -> {
                try { Thread.sleep(rnd.nextInt(5) * 200); } catch (InterruptedException ignored) {}
                AGV agv = agvs.get(taskId % K);
                agv.performTask(taskId);
            });
        }
        agvPool.shutdown();
        try { agvPool.awaitTermination(3, TimeUnit.MINUTES); } catch (InterruptedException ignored) {}
        log.writeRecord("Simulation ended");
    }
}
