public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
        int numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;
        Rational rational = new Rational(numerator, denominator);
        rational.reduce();
        return rational;
    }

    public static Rational plus(Rational a, Rational b) {
        int numerator = a.numerator * b.denominator + b.numerator * a.denominator;
        int denominator = a.denominator * b.denominator;
        Rational rational = new Rational(numerator, denominator);
        rational.reduce();
        return rational;
    }

    // Transforms this number into its reduced form

    private void reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {

        if (a < 0) {
            a *= -1;
        }

        if (b < 0) {
            b *= -1;
        }

        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    public int compareTo(Rational other) {
        float rational1 = (float)this.numerator / this.denominator;
        float rational2 = (float)other.numerator / other.denominator;
        return Float.compare(rational1, rational2);
    }

    public boolean equals(Rational other) {
        return ((this.numerator == other.numerator) && (this.denominator == other.denominator));
    }

    public String toString() {
        String result;
        if (denominator == 1) {
            result = Integer.toString(numerator);
        } else {
            result = (numerator + "/" + denominator);
        }
        return result;
    }

}