package SlidingWindow.Array.Medium;

public class MaximumGoodSubArraySum {
//https://leetcode.com/problems/maximum-good-subarray-sum/
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4};
        int k = 2;
        System.out.println(maximumSubarraySum(nums, k));
        System.out.println(optimizedApproach(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long maxVal = Long.MIN_VALUE;  // Use Long.MIN_VALUE to handle large sums

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            long sum = first;  // Start sum with first element

            for (int j = i + 1; j < nums.length; j++) {
                int last = nums[j];
                sum += last;  // Add current element to sum

                if (Math.abs(first - last) == k) {
                    maxVal = Math.max(maxVal, sum);
                }
            }
        }

        return maxVal == Long.MIN_VALUE ? 0 : maxVal; // If no valid subarray found, return 0
    }

    public static long optimizedApproach(int[] nums, int k) {
        int left = 0;
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right]; // Expand the window

            // Shrink the window until the condition is met
            while (left < right && Math.abs(nums[left] - nums[right]) > k) {
                currentSum -= nums[left];  // Remove leftmost element
                left++;  // Move left forward
            }

            // Check if the condition is met for the current window
            if (Math.abs(nums[left] - nums[right]) == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;

    }

}
