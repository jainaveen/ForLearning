package Array.Easy;

public class IMPMaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxProductSubArray(nums));
    }

    //Kadane's algorithm
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];  // Initialize current sum as the first element
        int maxSum = nums[0];      // Initialize max sum as the first element

        // Start from the second element and loop through the array
        for (int i = 1; i < nums.length; i++) {
            // Either continue with the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum encountered
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static long maxProductSubArray(int[] nums) {
        // max positive product
        // ending at the current position
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // Swapping min and max
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }



            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);


            ans = Math.max(ans, max);
        }

        return ans;
    }
}
