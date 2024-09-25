public class bubbleSort {
    public static void main(String[] args) {
        int MAX_NUM = 10;
        int[] arr=new int[MAX_NUM];
        for (int i = 0; i < MAX_NUM; i++) {
            arr[i] = (int)(Math.random()*MAX_NUM)+1;
        }
        System.out.println("Unsorted");
        for (int i = 0; i < MAX_NUM; i++) {
            System.out.print(arr[i]+" ");
        }
        for (int i = MAX_NUM; i != 0; i--) {
            for (int j = 0; j < MAX_NUM-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted");
        for (int i = 0; i < MAX_NUM; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
