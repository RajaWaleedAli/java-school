package introClasses.KassaBon;

import java.util.ArrayList;

public class Receipt {
    ArrayList<ReceiptItem> items;
    private static int index;
    public Receipt() {
        items = new ArrayList<>();
    }
    public boolean add(ReceiptItem a) {
        if(a.getAmount()>0 && a.getPrice()>=0 && a.getName()!=null) {
            items.add(a);
            return true;
        }else{
            return false;
        }
    }
    public void print() {
        System.out.println("Kassazettel:");
        double sum=0;
        for (ReceiptItem item : items) {
            System.out.println(item.getName()+"\n"+item.getAmount()+"x\t\t"+item.getPrice()+"€");
            sum+=item.getAmount()*item.getPrice();
        }
        System.out.println("Summe:\t"+String.format("%.2f", sum)+"€");
    }
}
