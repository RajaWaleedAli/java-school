import javax.swing.*;
import java.util.Arrays;

public class Stats {
    static double[] arr = new double[10];
    public static void main(String[] args) {
        arr=readNumber("Gib Zahlen ein");
        System.out.println(arr);
    }
    static double[] readNumber(String message){
        double num = 0;
        int i=0;
        do {
            if(i==arr.length-1){
                arr = Arrays.copyOf(arr, arr.length+2);
            }
            String s = JOptionPane.showInputDialog(message);
            num = Double.parseDouble(s);
            arr[i] = num;
            i++;
        }while (num>=0);
        return arr;

    }
}
