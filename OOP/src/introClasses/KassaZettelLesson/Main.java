package introClasses.KassaZettelLesson;

public class Main {
    public static void main(String[] args) {
// buy some items and create a receipt for it
        Receipt r = new Receipt();
        r.add( new ReceiptItem("15 Fischstäbchen", 3, 1.79) );
        r.add( new ReceiptItem("Steaks", 5, 3.99) );
        r.add( new ReceiptItem("Naturelle (1l)", 6, 4.99) );
        r.add( new ReceiptItem("Magnum Eis Creme", 2, 2.99) );
        r.print();
    }
}
