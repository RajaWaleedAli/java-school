package introClasses.RectangleLesson;

public class Rectangle {
    private int length;
    private int width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return (length * width);
    }
    public int getCircumference() {
        return (2 * (length+width));
    }
    public void setLength(int l) {
        if(l<0)
            length=0;
        else
            length=l;
    }
    public void setWidth(int w) {
        if (w<0)
            width=0;
        else
            width=w;
    }
    public int getLength() {
        return this.length;
    }
    public int getWidth() {
        return this.width;
    }
}
