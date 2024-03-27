package lab4_2;

import java.util.Iterator;

public class SmallestCommonMultipleSet implements Iterable<Integer> {
    private final int[] elements;

    public SmallestCommonMultipleSet(int[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SmallestCommonMultipleIterator();
    }

    private class SmallestCommonMultipleIterator implements Iterator<Integer> {
        private int currentMask;

        public SmallestCommonMultipleIterator() {
            currentMask = 1;
        }

        @Override
        public boolean hasNext() {
            return currentMask < (1 << elements.length);
        }

        @Override
        public Integer next() {
            int multiple = 1;
            int index = 0;
            int tempMask = currentMask;
            System.out.print("Subset: ");
            while (tempMask > 0) {
                if ((tempMask & 1) == 1) {
                    multiple = lcm(multiple, elements[index]);
                    System.out.print(elements[index]);
                    System.out.print(" ");
                }
                tempMask >>= 1;
                index++;
            }
            System.out.print("\n");
            currentMask++;
            return multiple;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        private int lcm(int a, int b) {
            return a * (b / gcd(a, b));
        }
    }

    public static void main(String[] args) {
        int[] elements = {2, 3, 5};
        SmallestCommonMultipleSet set = new SmallestCommonMultipleSet(elements);

        for (int scm : set) {
            System.out.println(scm);
        }
    }
}
