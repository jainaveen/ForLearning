package SlidingWindow.Array.Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumAverageSubArray {

    public static void main(String[] args) {
        int[] nums = {3,-2,5,-1,6,8};
        int k = 4;
        System.out.println("Max Average " +findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = Integer.MIN_VALUE;
        double calSum = 0;
        double calcAve = 0.0;
        int left = 0;
        for(int i=0; i<k; i++) {
            calSum += nums[i];
        }
        calcAve = calSum/k;
        maxAverage = Math.max(maxAverage,calcAve);
        for(int i = k; i<nums.length;i++) {
            calSum = calSum - nums[left++];
            calSum += nums[i];
            calcAve = calSum/k;
            maxAverage = Math.max(maxAverage,calcAve);
        }
        // Replace this placeholder return statement with your code
        return maxAverage;
    }
}
