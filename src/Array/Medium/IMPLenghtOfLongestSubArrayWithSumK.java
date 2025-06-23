package Array.Medium;

import java.util.*;

public class IMPLenghtOfLongestSubArrayWithSumK {

    public static void main(String[] args) {
        int nums[] = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println("Length of the longest subarray with sum " + k + " is: " + lenOfLongSubarr(nums, 0, 3));
    }

    // Optimal solution
    public static int lenOfLongSubarr (int nums[], int N, int K) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];

            // If cumulativeSum equals K, update maxLength
            if (cumulativeSum == K) {
                maxLength = i + 1;
            }

            // Check if (cumulativeSum - K) exists in map
            if (sumIndexMap.containsKey(cumulativeSum - K)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(cumulativeSum - K));
            }

            // Add cumulativeSum to map if it's not already present
            if (!sumIndexMap.containsKey(cumulativeSum)) {
                sumIndexMap.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }


}
