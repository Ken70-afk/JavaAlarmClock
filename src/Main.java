import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "morning_flower.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for: " + alarmTime);
            } catch (Exception e) {
                System.out.println("Invalid format. Please use HH:mm:ss");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmClockThread = new Thread(alarmClock);
        alarmClockThread.start();



    }
}
