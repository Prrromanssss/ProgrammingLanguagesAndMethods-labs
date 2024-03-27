package lab4;
public class Test {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction fraction3 = new Fraction(2, 1);
        Fraction fraction4 = new Fraction(4, 5);
        Fraction fraction5 = new Fraction(3, 1);
        Fraction fraction6 = new Fraction(5, 4);

        FractionPairIterable pairIterable = new FractionPairIterable(
            fraction1, fraction2, fraction3,
            fraction4, fraction5, fraction6
        );
        for (Fraction[] pair : pairIterable) {
            System.out.println("Pair: " + pair[0] + ", " + pair[1]);
        }
    }
}