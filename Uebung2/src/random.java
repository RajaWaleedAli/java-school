import java.util.Arrays;

public class random {
    public static void main(String[] args) {
        int[] arr=new int[3];
        arr[0] = (int)(Math.random()*10)+1;
        arr[1] = (int)(Math.random()*10)+1;
        arr[2] = (int)(Math.random()*10)+1;
        System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        Arrays.stream(arr).sorted().forEach(System.out::println);

    }
}
