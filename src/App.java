import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Speedometer speedometer = new Speedometer();

        double speed = 0.0;
        double speedLimit = 60.0;

        List<Ticket> ticketList = new ArrayList<Ticket>();
        
        for(int i = 0; i < 50; i++) {
            long measurement1 = speedometer.sensor1.getCurrentTimeMillis();

            // these two lines simulates the interval of a vehicle passing by the pair of sensors
            long interval = Double.valueOf(Math.random() * 60 + 40).longValue();
            Thread.sleep(interval);

            long measurement2 = speedometer.sensor2.getCurrentTimeMillis();

            speed = speedometer.getSpeed(measurement1, measurement2);

            Vehicle vehicle = new Vehicle(speed);

            if(speed > speedLimit) {
                Ticket ticket = new Ticket(vehicle);

                ticket.getLicencePlate();
                ticket.getSpeedPercentageExceeded(speedLimit);

                ticketList.add(ticket);

                // System.out.println("Vehicle fined!" + "\n" + "Date and time: " + ticket.dateTime + "\n" + "Speed exceeds limit: " + vehicle.speed + "\n");
            }
            else {
                System.out.println("Vehicle OK!");
            }

            Thread.sleep(500);
        }

        for(int i = 0; i < ticketList.size(); i++) {
            Ticket ticketNow = ticketList.get(i);

            System.out.println(ticketNow.vehicle.speed);
            System.out.println(ticketNow.vehicle.licensePlate);
            System.out.println(ticketNow.dateTime);
            System.out.println(ticketNow.speedPercentageExceeded);
        }

    }

}
 