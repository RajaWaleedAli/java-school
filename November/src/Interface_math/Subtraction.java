package Interface_math;

public class Subtraction extends Expr {
    private Expr minuend;
    private Expr subtrahend;
    public Subtraction(final Expr minuend, final Expr subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }
    public double eval() {
        System.out.println("Subtraction.eval()");
        return minuend.eval() - subtrahend.eval();
    }
}