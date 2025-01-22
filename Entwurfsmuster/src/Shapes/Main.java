package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        Shape composedShape = new ComposedShape();
        composedShape.add(circle);
        composedShape.add(rectangle);

        Shape composedShape2 = new ComposedShape();
        composedShape2.add(triangle);

        composedShape.add(composedShape2);

        System.out.println("Zusammengesetzte Form anzeigen:");
        composedShape.display();
    }
}
