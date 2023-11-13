public class Speedometer {
    Sensor sensor1;
    Sensor sensor2;

    double distance = 1.00000000000000; // distance between sensors in: meters
    double delayAdjusment = 3.0;

    double deltaTime;

    public Speedometer() {
        this.sensor1 = new Sensor();
        this.sensor2 = new Sensor();
    }

    public double getSpeed(long measurement1, long measurement2) {
        try {
            double initialTime = (double) measurement1;
            double finalTime = (double) measurement2;

            this.delayAdjusment = 2.0;
            this.deltaTime = (finalTime - initialTime - this.delayAdjusment) / 1000; // unit of measurement: seconds

            double speed = (this.distance / this.deltaTime) * 3.6; // unit of measurement: kilometers per hour

            return speed;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
