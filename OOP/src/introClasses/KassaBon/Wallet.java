package introClasses.KassaBon;

import java.util.ArrayList;

public class Wallet {
    ArrayList<Receipt> receipts;
    private final int MAX_RECEIPTS;
    public Wallet(int walletSize) {
        receipts = new ArrayList<>();
        MAX_RECEIPTS = walletSize;
    }
    public boolean addReceipt(Receipt receipt) {
        int index = receipts.size() - 1;
        if(index != MAX_RECEIPTS) {
            return receipts.add(receipt);
        }
        return false;
    }
    public boolean removeReceipt(Receipt receipt) {
        return receipts.remove(receipt);
    }
    public Receipt getReceipt(int index) {
        return receipts.get(index);
    }
    public int getReceiptCount() {
        return receipts.size();
    }
}
