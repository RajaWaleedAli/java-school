package Oktober.Interface_math;

public class Number implements Expr {
    private double num;
    public Number(double num) {
        this.num = num;
    }

    @Override
    public double eval() {
        return num;
    }
}
