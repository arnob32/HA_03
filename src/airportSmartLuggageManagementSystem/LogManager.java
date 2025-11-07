package airportSmartLuggageManagementSystem;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {

    
    public synchronized void writeLog(String folder, String fileName, String message) {
        try {
             
            File dir = new File("logs/" + folder);
            if (!dir.exists()) dir.mkdirs(); // file na thakle banabe

           
            String date = java.time.LocalDate.now().toString();
            File file = new File(dir, fileName + "_" + date + ".log");

            
            String timestamp = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
            String logLine = "[" + timestamp + "] " + message + System.lineSeparator();

            
            
            try (FileOutputStream fos = new FileOutputStream(file, true)) {
                fos.write(logLine.getBytes());
            }   
            
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(logLine);
            }

            
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }
}
