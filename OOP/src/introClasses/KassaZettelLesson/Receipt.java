package introClasses.KassaZettelLesson;

import java.util.ArrayList;

public class Receipt {
    ArrayList<ReceiptItem> items;
    private static int index;
    public Receipt() {
        items = new ArrayList<>();
    }
    public boolean add(ReceiptItem a) {
        items.add(a);
        index++;
        return true;
    }
    public void print() {
        for( ReceiptItem item : items ){
            System.out.println(item.toString());
        }
    }
}
