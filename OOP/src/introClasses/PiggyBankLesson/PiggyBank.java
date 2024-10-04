package introClasses.PiggyBankLesson;

public class PiggyBank {
    private int cent_1;
    private int cent_10;
    private int cent_50;
    private int cent_100;

    private final int centWeight_1=2;
    private final int centWeight_10=4;
    private final int centWeight_50=7;
    private final int centWeight_100=7;

    private final int capacity;
    private boolean broken;

    public PiggyBank(int capacity) {
        this.capacity = capacity;
        this.broken = false;
        this.cent_1 = 0;
        this.cent_10 = 0;
        this.cent_50 = 0;
        this.cent_100 = 0;
    }

    public int add1Cents(int count) {
        int countTotal = count+piggyCoins();
        if(countTotal>capacity) {
            return capacity-countTotal;
        }else {
            this.cent_1 += count;
            return 0;
        }
    }
    public int add10Cents(int count) {
        int countTotal = count+piggyCoins();
        if(countTotal>capacity) {
            return capacity-countTotal;
        }else{
            this.cent_10 += count;
            return 0;
        }
    }
    public int add50Cents(int count) {
        int countTotal = count+piggyCoins();
        if(countTotal>capacity) {
            return capacity-countTotal;
        }else{
            this.cent_50 += count;
            return 0;
        }
    }
    public int add100Cents(int count) {
        int countTotal = count+piggyCoins();
        if(countTotal>capacity) {
            return capacity-countTotal;
        }else{
            this.cent_100 += count;
            return 0;
        }
    }

    public boolean isEmpty() {
        return piggyCoins() == 0;
    }
    public boolean isFull() {
        return piggyCoins() == capacity;
    }

    public boolean isBroken() {
        return broken;
    }
    public int breakInto(){
        broken=true;
        int temp = cent_1+cent_10*10+cent_50*50+cent_100*100;
        this.cent_1 = 0;
        this.cent_10 = 0;
        this.cent_50 = 0;
        this.cent_100 = 0;
        return temp;
    }

    public boolean addCoins(int c1, int c10, int c50, int c100) {
        if(c1+c10+c50+c100+piggyCoins() <= capacity) {
            this.cent_1 += c1;
            this.cent_10 += c10;
            this.cent_50 += c50;
            this.cent_100 += c100;
            return true;
        }else
            return false;
    }
    public int piggyWeight(){
        return cent_1*centWeight_1+cent_10*centWeight_10+cent_50*centWeight_50+cent_100*centWeight_100;
    }
    public int piggyCoins(){
        return cent_1 + cent_10 + cent_50 + cent_100;
    }
    public boolean isLighterThan(PiggyBank piggyBank) {
        int weight1=piggyWeight();
        int weight2=piggyBank.piggyWeight();
        return weight1<weight2;
    }

}
