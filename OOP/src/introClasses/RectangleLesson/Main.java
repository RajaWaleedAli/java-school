package introClasses.RectangleLesson;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,3);

        System.out.println("Fläche: "+rectangle.getArea());
        System.out.println("Circumference: "+rectangle.getCircumference());
    }
}
