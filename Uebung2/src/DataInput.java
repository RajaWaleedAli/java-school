import javax.swing.*;

public class DataInput {
    public static void main(String[] args) {
        String msg=readNumber("Enter a number: ");
        System.out.println(msg);
    }
    static String readNumber(String message){

        String s = JOptionPane.showInputDialog(message);
        return s;
    }
}
