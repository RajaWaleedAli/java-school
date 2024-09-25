public class TypeTest {
    public static void main(String[] args) {
        short s = 10;
        float f = 100.5f;
        double d = 200.6, sum;
        boolean flag = true;
        char c = 'x';
        System.out.println("s = " + s + " f = " + f + " d = " + d);  //10 100.50 200.6000
        sum = s + f + d;
        System.out.println(flag);   //true
        System.out.println(c);      //x
        System.out.println("sum = " + sum); //311,100
        System.out.println(2 + "test" + 3); //2test3
        System.out.println(2 + 3 + "test"); //5test
        System.out.println("test" + 2 + 3); //test23
        System.out.println("test" + 2 * 3); //test6
    }
}