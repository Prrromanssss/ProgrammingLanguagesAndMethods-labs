package lab4_2;

public class Test {
    public static void main(String[] args) {
        int[] elements = {2, 3, 5};
        SmallestCommonMultipleSet set = new SmallestCommonMultipleSet(elements);

        for (int scm : set) {
            System.out.println(scm);
        }
    }
}
