import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    Vehicle vehicle;
    String dateTime;
    Double speedPercentageExceeded;

    public Ticket(Vehicle vehicle) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatedDateTime = localDateTime.format(format);

        this.vehicle = vehicle;
        this.dateTime = formatedDateTime;
    }

    public void getLicencePlate() {
        System.out.println("Taking photo of licence plate...");
        this.vehicle.licensePlate = true;
    }

    public void getSpeedPercentageExceeded(double speedLimit) {
        double percentage = (this.vehicle.speed / (speedLimit / 100)) - 100;
        this.speedPercentageExceeded = percentage;
    }
}
