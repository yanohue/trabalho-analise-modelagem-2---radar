public class App {
    public static void main(String[] args) throws Exception {
        Sensor sensor = new Sensor();
        float measurement[] = sensor.getTimeSimulation();

        Speedometer speedometer = new Speedometer();
        float speed = speedometer.getSpeed(measurement[0], measurement[1]);

        System.out.println(measurement[0] + " ms");
        System.out.println(measurement[1] + " ms");
        System.out.println(speed + " km/h");

    }
}
 