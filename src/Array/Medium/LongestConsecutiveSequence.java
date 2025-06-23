package Array.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    //https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        int[] nums = {100,4,200,3,1,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int maxValue = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currCount = 1;

                while (set.remove(currNum + 1)) {
                    currNum++;
                    currCount++;
                }
                maxValue = Math.max(maxValue, currCount);
            }
        }
        return maxValue;
    }


}

