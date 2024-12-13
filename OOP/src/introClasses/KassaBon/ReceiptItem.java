package introClasses.KassaBon;

public class ReceiptItem {
    private String name;
    private int amount;
    private double price;

    public ReceiptItem(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
