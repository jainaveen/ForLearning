package Array.Medium;

public class IMPMaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {6,-9,7,91,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
