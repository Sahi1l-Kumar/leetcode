package classes_and_objects;

public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new Error("Denominator cannot be 0");
        }
        this.denominator = denominator;
        simplify();
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public void setDenominator(int denominator) throws ZeroDenominatorException {
        if (denominator == 0) {
            ZeroDenominatorException e = new ZeroDenominatorException();
            throw e;
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

    private void simplify() {
        int gcd = 1;
        int smaller = Math.min(numerator, denominator);

        for (int i = 1; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public void add(Fraction f) {
        this.numerator = this.numerator * f.denominator + f.numerator * this.denominator;
        this.denominator = this.denominator * f.denominator;
        simplify();
    }

    public void multiply(Fraction f) {
        this.numerator = this.numerator * f.numerator;
        this.denominator = this.denominator * f.denominator;
        simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int numerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int denominator = f1.denominator * f2.denominator;

        Fraction f3 = new Fraction(numerator, denominator);
        return f3;
    }
}
