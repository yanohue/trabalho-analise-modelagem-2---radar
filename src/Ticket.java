import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    Vehicle vehicle;
    String dateTime;
    double speedPercentageExceeded;

    public Ticket(Vehicle vehicle) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatedDateTime = localDateTime.format(format);

        this.vehicle = vehicle;
        this.vehicle.getLicencePlate();
        this.dateTime = formatedDateTime;
    }

    public void getSpeedPercentageExceeded(double speedLimit) {
        long percentage = Math.round((this.vehicle.speed / (speedLimit / 100)) - 100);
        this.speedPercentageExceeded = (double) percentage;
    }
}
