package Educative.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeValues {

    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int left = i +1;
            int right = nums.length-1;

            if(start > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while(left < right) {
                int sum =  nums[start] + nums[left] + nums[right];

                if(sum == 0) {
                    result.add(Arrays.asList(nums[start], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
