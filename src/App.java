import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        Sensor sensor = new Sensor();
        float measurement[] = sensor.getTimeSimulation();

        Speedometer speedometer = new Speedometer();
        float speed = speedometer.getSpeed(measurement[0], measurement[1]);

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatedDateTime = localDateTime.format(format);

        LocalTime preciseTime = LocalTime.now();

        System.out.println(formatedDateTime);
        System.out.println(preciseTime);


        System.out.println(measurement[0] + " ms");
        System.out.println(measurement[1] + " ms");
        System.out.println(speed + " km/h");

    }
}
 