package airportSmartLuggageManagementSystem;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LogManager log = new LogManager();
        QueueManage cqm = new QueueManage(3, log); // 3 charging stations

        Random rnd = new Random();

        for (int i = 1; i <= 10; i++) {
            AGV agv = new AGV(i); 
            long arrivalDelay = rnd.nextInt(26) * 200L; 
            new Thread(() -> {
                try { Thread.sleep(arrivalDelay); } catch (InterruptedException ignored) {}
                cqm.requestCharge(agv);
            }).start();
        }

        // Run simulation for a bit, then stop
        try { Thread.sleep(8000); } catch (InterruptedException ignored) {}
        cqm.shutdown();
        System.out.println("✅ Simulation finished. Check logs folder.");
    }
}
