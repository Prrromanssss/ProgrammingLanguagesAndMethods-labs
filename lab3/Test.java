package lab3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        VectorPair[] vectorPairs = new VectorPair[] {
            new VectorPair(new Vector3D(0, 0, 0), new Vector3D(6, 3, -2)),
            new VectorPair(new Vector3D(7, 8, 9), new Vector3D(1, -9, -2)),
            new VectorPair(new Vector3D(4, -2, 7), new Vector3D(-1, 0, -5)),
        };

        Arrays.sort(vectorPairs);
        for (VectorPair vp : vectorPairs) {
            System.out.println(vp);
        }
    }
}
