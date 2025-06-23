package Array.Easy;

import java.util.Arrays;

public class IMPPlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9})));
    }
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the current digit is 9, set it to 0
            digits[i] = 0;
        }

        // If all digits were 9, create a new array with an extra length and set the first element to 1
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }


}
