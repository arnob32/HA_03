package airportSmartLuggageManagementSystem;

public class ChargingStation {
    private final int id;
    private final LogService log;

    public ChargingStation(int id, LogService log) {
        this.id = id;
        this.log = log;
    }

    public void charge(AGV agv) throws InterruptedException {
        log.writeRecord("Station " + id + ": Charging AGV " + agv.getId());
        Thread.sleep(4000); // simulate charge time
        agv.setBattery(100);
        log.writeRecord("Station " + id + ": Finished charging AGV " + agv.getId());
    }
}