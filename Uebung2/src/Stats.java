import javax.swing.*;
import java.util.Arrays;

public class Stats {
    static double[] arr = new double[10];
    public static void main(String[] args) {
        arr=readNumber("Gib Zahlen ein");
        System.out.println("Unsorted: "+arr);
        Arrays.sort(arr);
        double big, small, avg;
        big=arr[0];
        small=arr[0];
        avg=Arrays.stream(arr).sum()/arr.length;
        for(i=1;i<arr.length-1;i++){
            if(arr[i]>big)
                big=arr[i];
            else if (arr[i]<small) {
                small=arr[i];
            }
        }
        System.out.println("Sorted: "+arr);
        System.out.println("Biggest: "+big);
        System.out.println("Smallest: "+small);
        System.out.println("Average: "+avg);

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
