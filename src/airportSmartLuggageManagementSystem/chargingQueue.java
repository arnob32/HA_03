package airportSmartLuggageManagementSystem;


	import java.util.Map;
	import java.util.concurrent.*;

	public class chargingQueue {
	    private final int stations;
	    private final ExecutorService chargingPool;
	    private final BlockingQueue<AGV> waitingQueue = new LinkedBlockingQueue<>();
	    private final Map<Integer, Long> arrivalTimes = new ConcurrentHashMap<>();
	    private final LogService log;
	    private static final long SIM_MINUTE_MS = 200;
	    private static final long MAX_WAIT_MS = 15 * SIM_MINUTE_MS; // 15 simulated minutes

	    public chargingQueue(int stations, LogService log) {
	        this.stations = stations;
	        this.log = log;
	        this.chargingPool = Executors.newFixedThreadPool(stations);
	        startDispatcher();
	    }

	    public void requestCharge(AGV agv) {
	        arrivalTimes.put(agv.getId(), System.currentTimeMillis());
	        waitingQueue.offer(agv);
	        log.writeRecord("AGV " + agv.getId() + " entered charging queue.");
	    }

	    private void startDispatcher() {
	        Thread dispatcher = new Thread(() -> {
	            while (true) {
	                try {
	                    AGV agv = waitingQueue.take();
	                    long waited = System.currentTimeMillis() - arrivalTimes.getOrDefault(agv.getId(), 0L);
	                    if (waited > MAX_WAIT_MS) {
	                        log.writeRecord("AGV " + agv.getId() + " left queue (waited too long)");
	                        continue;
	                    }
	                    chargingPool.submit(() -> doCharge(agv));
	                } catch (InterruptedException ignored) {}
	            }
	        });
	        dispatcher.setDaemon(true);
	        dispatcher.start();
	    }

	    private void doCharge(AGV agv) {
	        int stationId = (int)(Thread.currentThread().getId() % stations) + 1;
	        ChargingStation station = new ChargingStation(stationId, log);
	        try {
	            station.charge(agv);
	        } catch (InterruptedException ignored) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    public void shutdown() { chargingPool.shutdownNow(); }
	}
