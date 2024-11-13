package RationalNumber;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public RationalNumber(RationalNumber r) {
        this.numerator = r.numerator;
        this.denominator = r.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (Math.abs(numerator) < denominator) {
            return numerator + "/" + denominator;
        } else {
            int wholePart = numerator / denominator;
            int remainder = Math.abs(numerator % denominator);
            if (remainder == 0) {
                return String.valueOf(wholePart);
            } else {
                return wholePart + " " + remainder + "/" + denominator;
            }
        }
    }

    public RationalNumber add(RationalNumber rhs) {
        int newNumerator = this.numerator * rhs.denominator + rhs.numerator * this.denominator;
        int newDenominator = this.denominator * rhs.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber sub(RationalNumber rhs) {
        int newNumerator = this.numerator * rhs.denominator - rhs.numerator * this.denominator;
        int newDenominator = this.denominator * rhs.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber mult(RationalNumber rhs) {
        int newNumerator = this.numerator * rhs.numerator;
        int newDenominator = this.denominator * rhs.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public RationalNumber div(RationalNumber rhs) {
        if (rhs.numerator == 0) {
            throw new ArithmeticException("Division by zero.");
        }
        int newNumerator = this.numerator * rhs.denominator;
        int newDenominator = this.denominator * rhs.numerator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    private RationalNumber simplify() {
        int gcd = GCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {  
            numerator = -numerator;
            denominator = -denominator;
        }
        return this;
    }

    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    private int LCM(int a, int b) {
        return Math.abs(a * b) / GCD(a, b);
    }
}