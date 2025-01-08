package Log;

class DuaLog {
    static double duaLog(double arg) {
        if(arg<0){
            throw new IllegalArgumentException("Argument must be positive");
        }
        return Math.log(arg) / Math.log(2);

    }
    public static void main(String[] args) {

        double a = duaLog(8);
        double b = duaLog(-1);
        System.out.println(a*b);

    }
}
