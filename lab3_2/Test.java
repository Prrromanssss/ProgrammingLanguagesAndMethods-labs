package lab3_2;

import java.util.Arrays;


public class Test {
        public static void main(String[] args) {
            Vector3D[] vector3Ds = new Vector3D[] {
                new Vector3D(0, 0, 0),
                new Vector3D(7, 8, 9),
                new Vector3D(4, -2, 7),
            };

            Arrays.sort(vector3Ds);
            for (Vector3D v : vector3Ds) {
                System.out.println(v);
            }
    }
}
