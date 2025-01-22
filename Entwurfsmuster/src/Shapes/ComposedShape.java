package Shapes;

import java.util.ArrayList;

public class ComposedShape extends Shape{
    private ArrayList<Shape> shapes;
    ComposedShape() {
        this.shapes = new ArrayList<>();
    }

    public void display() {
        for (Shape shape : shapes) {
            shape.display();
        }
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }
}
