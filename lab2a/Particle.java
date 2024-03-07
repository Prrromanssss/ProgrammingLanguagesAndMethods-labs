package lab2a;

public class Particle {
    private double mass;
    private double x;
    private double y;
    private double z;

    public Particle(double mass, double x, double y, double z) {
        this.mass = mass;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getMass() {
        return mass;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
