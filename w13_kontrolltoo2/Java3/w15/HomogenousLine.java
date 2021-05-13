package w15;

public class HomogenousLine implements LineSolver {

    private double slope;

    public HomogenousLine(double slope) {
        this.slope = slope;
    }

    public double solve(double x) {
        return this.slope * x;
    }

    public double getSlope() {
        return this.slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

}