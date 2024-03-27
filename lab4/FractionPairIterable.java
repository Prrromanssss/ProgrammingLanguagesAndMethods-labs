package lab4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FractionPairIterable implements Iterable<Fraction[]> {
    private Fraction[] fractions;

    public FractionPairIterable(Fraction... fractions) {
        this.fractions = fractions;
        filterFractions();
    }

    @Override
    public Iterator<Fraction[]> iterator() {
        return new FractionPairIterator();
    }

    private class FractionPairIterator implements Iterator<Fraction[]> {
        private int currentIndex1;
        private int currentIndex2;

        public FractionPairIterator() {
            this.currentIndex1 = 0;
            this.currentIndex2 = 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex1 < fractions.length - 1;
        }

        @Override
        public Fraction[] next() {
            Fraction[] pair = new Fraction[2];
            pair[0] = fractions[currentIndex1];
            pair[1] = fractions[currentIndex2];

            currentIndex1 += 2;
            currentIndex2 += 2;

            return pair;
        }
    }

    private void filterFractions() {
        List<Fraction[]> filteredFractions = new ArrayList<>();
        for (int i = 0; i < fractions.length; i++) {
            for (int j = i + 1; j < fractions.length; j++) {
                if (fractions[i].multiply(fractions[j]) == 1.0) {
                    Fraction[] pair = {fractions[i], fractions[j]};
                    filteredFractions.add(pair);
                    break;
                }
            }
        }

        Fraction[][] filteredFractionsArray = filteredFractions.toArray(new Fraction[0][2]);
        fractions = new Fraction[filteredFractionsArray.length * 2];
        int index = 0;
        for (Fraction[] pair : filteredFractionsArray) {
            fractions[index++] = pair[0];
            fractions[index++] = pair[1];
        }
    }
}