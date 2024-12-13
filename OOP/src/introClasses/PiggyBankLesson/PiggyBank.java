/*
Autor: Raja Waleed Ali
Datum: 09.10.2024
Beschreibung: Piggy Bank
*/
package introClasses.PiggyBankLesson;

public class PiggyBank {
    private int cent_1;
    private int cent_10;
    private int cent_50;
    private int cent_100;

    private final int centWeight_1;
    private final int centWeight_10;
    private final int centWeight_50;
    private final int centWeight_100;

    private final int capacity;
    private boolean broken;

    public PiggyBank(int capacity) {
        this.capacity = capacity;
        this.broken = false;
        this.cent_1 = 0;
        this.cent_10 = 0;
        this.cent_50 = 0;
        this.cent_100 = 0;
        this.centWeight_1=2;
        this.centWeight_10=4;
        this.centWeight_50=7;
        this.centWeight_100=7;
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
    public boolean addCoin_New(PiggyBank piggy) {
        switch (1){
            case 1:
                if(piggy.getCent_1()!=this.cent_1){break;}
            case 2:
                if(piggy.getCent_10()!=this.cent_10){break;}
            case 3:
                if(piggy.getCent_50()!=this.cent_50){break;}
            case 4:
                if(piggy.getCent_100()!=this.cent_100){break;}
            case 5:
                if(piggy.getCapacity()!=this.capacity){break;}
            case 6:
                return false;
        }
        piggy.setBroken(true);
        if(this.capacity==piggyCoins()){
            return true;
        }
        if(add1Cents(piggy.getCent_1())!=0){
            piggy.setCent_1(add1Cents(piggy.getCent_1()));
            this.cent_1 += capacity-piggyCoins();
            return true;
        }else{
            this.cent_1 += piggy.getCent_1();
            piggy.setCent_1(0);
        }
        if(add10Cents(piggy.getCent_10())!=0){
            piggy.setCent_10(add10Cents(piggy.getCent_10()));
            this.cent_10 += capacity-piggyCoins();
            return true;
        }else {
            this.cent_10 += piggy.getCent_1();
            piggy.setCent_10(0);
        }
        if(add50Cents(piggy.getCent_50())!=0){
            piggy.setCent_50(add50Cents(piggy.getCent_50()));
            this.cent_50 += capacity-piggyCoins();
            return true;
        }else{
            this.cent_50 += piggy.getCent_1();
            piggy.setCent_50(0);
        }
        if(add100Cents(piggy.getCent_100())!=0){
            piggy.setCent_100(add100Cents(piggy.getCent_100()));
            this.cent_100 += capacity-piggyCoins();
            return true;
        }else{
            this.cent_100 += piggy.getCent_100();
            piggy.setCent_100(0);
        }
        return true;
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

    //getter and setter
    public int getCent_1() {
        return cent_1;
    }
    public int getCent_10() {
        return cent_10;
    }
    public int getCent_50() {
        return cent_50;
    }
    public int getCent_100() {
        return cent_100;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCent_1(int cent_1) {
        this.cent_1 = cent_1;
    }
    public void setCent_10(int cent_10) {
        this.cent_10 = cent_10;
    }
    public void setCent_50(int cent_50) {
        this.cent_50 = cent_50;
    }
    public void setCent_100(int cent_100) {
        this.cent_100 = cent_100;
    }
    public void setBroken(boolean broken) {
        this.broken = broken;
    }
}
