package Array.Easy;

import java.util.Arrays;

public class SumZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(7)));
    }
    public static int[] sumZero(int n) {
        // check even or odd
        int[] result = new int[n];
        int index = 0;

        // If n is odd, include 0
        if (n % 2 != 0) {
            result[index++] = 0;  // Add zero at the start
            n--;
        }

        // Add pairs of positive and negative integers
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;    // Positive number
            result[index++] = -i;   // Corresponding negative number
        }

        return result;


    }
}
