package Interface_math;

public class Multiplication extends Expr {
    private Expr factor1;
    private Expr factor2;
    public Multiplication(final Expr factor1, final Expr factor2) {
        this.factor1 = factor1;
        this.factor2 = factor2;
    }
    public double eval() {
        System.out.println("Multiplication.eval()");
        return factor1.eval() * factor2.eval();
    }
}
