package lab4_2;

public class Test {
    public static void main(String[] args) {
        int[] elements = {4, 6, 10};
        SmallestCommonMultipleSet set = new SmallestCommonMultipleSet(elements);

        for (int scm : set) {
            System.out.println(scm);
        }
    }
}
