package Interface_math;

public class Addition extends Expr {
    private final Expr addend1;
    private final Expr addend2;
    public Addition(final Expr addend, final Expr addend2) {
        this.addend1 = addend;
        this.addend2 = addend2;
    }
    public double eval() {
        System.out.println("Addition.eval()");
        return addend1.eval() + addend2.eval();
    }
}