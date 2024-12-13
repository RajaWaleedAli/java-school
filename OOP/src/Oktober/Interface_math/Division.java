package Oktober.Interface_math;

public class Division implements Expr {
    private Expr dividend;
    private Expr divisor;
    public Division(final Expr dividend, final Expr divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    public double eval() {
        System.out.println("Division.eval()");
        return dividend.eval() / divisor.eval();
    }
}