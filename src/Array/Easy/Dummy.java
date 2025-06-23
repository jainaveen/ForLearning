package Array.Easy;

import java.util.concurrent.PriorityBlockingQueue;

public class Dummy {

    public static void main(String[] args) {
        int[] arr = {8,2,6,4,5};
        int k = 3;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length-k; i++) {
                min = arr[i];
            for (int j = i+1; j < k+i; j++) {
                min = Math.min(min, arr[j]);
            }
            max = Math.max(min, max);
        }
        System.out.println("Max Value " + max);
    }
}
