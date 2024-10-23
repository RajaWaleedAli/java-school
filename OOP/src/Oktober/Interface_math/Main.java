package Oktober.Interface_math;

public class Main {
    public static void main(String[] args) {
        Number x = new Number(9);
        Number y = new Number(3);
        Number z = new Number(-2);

        Expr rechnung = new Division(
                new Power(
                        new Subtraction(
                                new Addition(
                                        new Multiplication(
                                                new Power(x, new Number(3)),
                                                new Number(3)
                                        ),
                                        new Multiplication(
                                                new Number(3),
                                                new Power(y, new Number(2))
                                        )
                                ),
                                new Multiplication(new Number(2), z)
                        ),
                        new Number(0.5)
                ),
                new Subtraction(
                        new Addition(
                                x,
                                new Multiplication(new Number(5),y)
                        ),
                        new Multiplication(new Number(8),z)
                )
        );
        System.out.println("Loesung: " + rechnung.eval());
    }
}
