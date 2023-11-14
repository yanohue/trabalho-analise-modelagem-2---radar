import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Speedometer speedometer = new Speedometer();

        double speed = 0.0;
        double speedLimit = 60.0;

        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        List<Ticket> ticketList = new ArrayList<Ticket>();
        
        for(int i = 0; i < 50; i++) {
            long timestamp1 = speedometer.sensor1.getCurrentTimeMillis();

            // these two lines simulates the interval of a vehicle passing by the pair of sensors
            long interval = Double.valueOf(Math.random() * 60 + 40).longValue();
            Thread.sleep(interval);

            long timestamp2 = speedometer.sensor2.getCurrentTimeMillis();

            speed = speedometer.getSpeed(timestamp1, timestamp2);

            Vehicle vehicle = new Vehicle((double) Math.round(speed));
            vehicleList.add(vehicle);

            if(vehicle.speed > speedLimit) {
                Ticket ticket = new Ticket(vehicle);
                ticket.getSpeedPercentageExceeded(speedLimit);
                ticketList.add(ticket);
            }
            else {
                System.out.println("Vehicle OK!");
            }

            Thread.sleep(500);
        }

        for(int i = 0; i < ticketList.size(); i++) {
            Ticket ticketNow = ticketList.get(i);

            System.out.println("\n");
            System.out.println("Speed: " + ticketNow.vehicle.speed + "km/h");
            System.out.println("Speed limit percentage exceeded: " + ticketNow.speedPercentageExceeded + "%");
            System.out.println("Date and Time: " + ticketNow.dateTime);
            System.out.println("Licente plate: " + ticketNow.vehicle.licensePlate);
        }

    }

}
 