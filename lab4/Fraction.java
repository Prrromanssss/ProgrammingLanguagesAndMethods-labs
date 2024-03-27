package lab4;
public class Fraction {
    public static final Fraction ONE = new Fraction(1, 1);

    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }

    public double multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return (double) newNumerator / newDenominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}