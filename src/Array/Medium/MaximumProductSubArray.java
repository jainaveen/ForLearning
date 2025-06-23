package Array.Medium;

//Confusion
public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 6, -3, -10, 0, 2};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], currMax * nums[i]);
            currMin = Math.min(nums[i], currMin * nums[i]);

            maxValue = Math.max(maxValue, currMax);
        }

        return maxValue;
    }


}
