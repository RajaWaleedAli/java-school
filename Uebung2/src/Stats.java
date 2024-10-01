import javax.swing.*;
import java.util.Arrays;

public class Stats {
    static double[] arr = new double[10];
    static int count = 0;

    public static void main(String[] args) {
        arr = readNumber("Gib Zahlen ein");
        arr = Arrays.copyOf(arr, count);  // Resize array to actual number of inputs

        if (count > 0) {
            System.out.println("Eingegebene Zahlen: " + Arrays.toString(arr));
            System.out.println("Minimum: " + findMin(arr));
            System.out.println("Maximum: " + findMax(arr));
            System.out.println("Arithmetisches Mittel: " + calculateMean(arr));
            System.out.println("Median: " + calculateMedian(arr));
        } else {
            System.out.println("Keine gültigen Zahlen eingegeben.");
        }
    }

    static double[] readNumber(String message) {
        double num;
        int i = 0;

        do {
            String s = JOptionPane.showInputDialog(message);
            num = Double.parseDouble(s);

            if (num < 0) break;  // Beenden bei negativer Zahl

            if (i == arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);  // Erhöhen der Arraygröße
            }

            arr[i] = num;
            i++;
        } while (num >= 0);

        count = i;  // Speichern der tatsächlichen Anzahl der eingegebenen Zahlen
        return arr;
    }

    static double findMin(double[] array) {
        double min = array[0];
        for (double num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    static double calculateMean(double[] array) {
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    static double calculateMedian(double[] array) {
        Arrays.sort(array);  // Sortieren des Arrays
        int mid = array.length / 2;

        if (array.length % 2 == 0) {
            return (array[mid - 1] + array[mid]) / 2.0;  // Median für gerade Anzahl
        } else {
            return array[mid];  // Median für ungerade Anzahl
        }
    }
}
