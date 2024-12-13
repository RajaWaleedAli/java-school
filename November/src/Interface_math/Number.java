package Interface_math;

public class Number extends Expr {
    private double num;
    public Number(double num) {
        this.num = num;
    }

    @Override
    public double eval() {
        System.out.println("Number.eval()");
        return num;
    }
}
