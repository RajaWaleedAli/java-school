package introClasses.BankLesson;

public class BankAcc {
    private float balance;
    private long accountNumber;
    private String name;

    public BankAcc(long accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public float getBalance() {
        return this.balance;
    }
    public long getAccountNumber() {
        return this.accountNumber;
    }
    public String getName() {
        return this.name;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean deposit(float amount) {
        this.balance += amount;
        return true;
    }
    public boolean withdraw(float amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }else
            return false;

    }
}
