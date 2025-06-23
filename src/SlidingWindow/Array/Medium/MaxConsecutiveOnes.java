package SlidingWindow.Array.Medium;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnes {
//https://leetcode.com/problems/max-consecutive-ones-iii/
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int zeroFlip = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroFlip++;
            }
            while (zeroFlip > k) {
                if (nums[left] == 0) {
                    zeroFlip--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
