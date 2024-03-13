package lab3;

class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3D vectorProduct(Vector3D v1, Vector3D v2) {
        double x = v1.y * v2.z - v1.z * v2.y;
        double y = v1.z * v2.x - v1.x * v2.z;
        double z = v1.x * v2.y - v1.y * v2.x;
        return new Vector3D(x, y, z);
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public String toString() {
        return "Vector3D: x = " + x + ", y = " + y + ", z = " + z;
    }
}

public class VectorPair implements Comparable<VectorPair> {
    private Vector3D vector1, vector2;

    public VectorPair(Vector3D vector1, Vector3D vector2) {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    public double vectorProductLength() {
        return Vector3D.vectorProduct(vector1, vector2).length();
    }

    public int compareTo(VectorPair other) {
        if (vectorProductLength() == 0 && other.vectorProductLength() == 0) {
            return 0;
        } else if (vectorProductLength() == 0) {
            return -1;
        } else if (other.vectorProductLength() == 0) {
            return 1;
        } else {
            return (int) (vectorProductLength() - other.vectorProductLength());
        }
    }

    public String toString() {
        return "{ " + vector1.toString() + "; " + vector2.toString() + " }";
    }
}