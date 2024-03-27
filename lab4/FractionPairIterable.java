package lab4;
import java.util.Iterator;

class FractionPairIterable implements Iterable<Fraction[]> {
    private int maxDenominator;

    public FractionPairIterable(int maxDenominator) {
        this.maxDenominator = maxDenominator;
    }

    @Override
    public Iterator<Fraction[]> iterator() {
        return new FractionPairIterator();
    }

    private class FractionPairIterator implements Iterator<Fraction[]> {
        private int currentNumerator;
        private int currentDenominator;

        public FractionPairIterator() {
            this.currentNumerator = 1;
            this.currentDenominator = maxDenominator;
        }

        @Override
        public boolean hasNext() {
            return currentNumerator < currentDenominator;
        }

        @Override
        public Fraction[] next() {
            Fraction[] pair = new Fraction[2];
            pair[0] = new Fraction(currentNumerator, currentDenominator);
            pair[1] = new Fraction(currentDenominator, currentNumerator);

            currentNumerator++;
            if (currentNumerator >= currentDenominator) {
                currentNumerator = 1;
                currentDenominator--;
            }

            return pair;
        }
    }
}