package Array.Medium;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
       System.out.println(Arrays.toString(productExceptSelf(nums)));

      //  System.out.println(Arrays.toString(bruteForce(nums)));
    }

    public static int[] bruteForce(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = 1;
            for (int j = 0; j < nums.length; j++) {
                if(i != j) {
                    v = v * nums[j];
                }
            }
            res[i] = v;
        }
        return res;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute the left product for each element
        result[0] = 1; // There is no element to the left of the first element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute the right product and multiply it with the left product
        int rightProduct = 1; // Initialize right product as 1 (no elements to the right initially)
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct; // Multiply left product with the current right product
            rightProduct *= nums[i]; // Update right product
        }

        return result;
    }
}
