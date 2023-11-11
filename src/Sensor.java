public class Sensor {
    float time[];

    public Sensor() {
        this.time = new float[2];
    }

    public float[] getTimeSimulation() {    // unit of measure: milliseconds
        this.time[0] = (float) Math.random() * 999 + 1;
        this.time[1] = (float) Math.random() * 999 + 1;

        while(this.time[0] > this.time[1]) {
            this.time[1] += (float) Math.random() * 100 + 40;
        }

        return this.time;
    }
}
