package lab4;
public class Test {
    public static void main(String[] args) {
        int maxDenominator = 10;
        FractionPairIterable fractionPairs = new FractionPairIterable(maxDenominator);

        for (Fraction[] pair : fractionPairs) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }
}