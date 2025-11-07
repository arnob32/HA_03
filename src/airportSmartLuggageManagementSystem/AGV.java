package airportSmartLuggageManagementSystem;

public class AGV {
    private final int id;
    private double battery = 100;

    public AGV(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public double getBattery() { return battery; }
    public void setBattery(double battery) { this.battery = battery; }

	public void performTask(int taskId) {
		// TODO Auto-generated method stub
		
	}
}

