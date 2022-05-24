public class Geometric extends AbstractSeries {

    private double denominator = 0.5;
    private double sum = 0;
    
    public double next() {
        sum += 1/(denominator *= 2);
        return sum;
    }
}
