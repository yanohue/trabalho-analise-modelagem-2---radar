public class Speedometer {
    float deltaTime;
    float distance = 1; // distance between sensors in: meters

    float speed;

    public Speedometer() {
        this.deltaTime = -1;
        this.speed = -1; // unit of measure: kilometers per hour
    }

    public float getSpeed(float initialTime, float finalTime) {
        try {
            this.deltaTime = finalTime - initialTime;
            this.speed = (this.distance / (this.deltaTime / 1000) * 3600) / 1000;

            return this.speed;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
