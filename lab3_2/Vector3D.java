package lab3_2;

public class Vector3D implements Comparable<Vector3D> {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double angleToXYPlane()  {
        return Math.atan2(Math.sqrt(x * x + y * y), z);
    }

    public double dotProduct(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public int compareTo(Vector3D other) {
        if (angleToXYPlane() < other.angleToXYPlane()) {
            return -1;
        } else if (angleToXYPlane() > other.angleToXYPlane()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Vector3D: x = " + x + ", y = " + y + ", z = " + z;
    } 
}
