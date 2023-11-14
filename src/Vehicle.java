public class Vehicle {
    double speed;
    boolean licensePlate;

    public Vehicle(double speed) {
        this.speed = speed;
        this.licensePlate = false;
    }

    public void getLicencePlate() {
        System.out.println("Taking photo of licence plate...");
        this.licensePlate = true;
    }
}
