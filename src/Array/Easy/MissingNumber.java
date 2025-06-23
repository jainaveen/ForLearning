package Array.Easy;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 10};

        for (int i = 1; i < arr.length-1; i++) {
            int prev = arr[i-1];
            int curr = arr[i];
            if(curr - prev > 1) {
                System.out.println("missing number " + (prev+1));
                break;
            }
        }
    }
}
