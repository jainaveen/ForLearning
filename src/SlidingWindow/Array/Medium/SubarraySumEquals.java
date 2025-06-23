package SlidingWindow.Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEquals {
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        //System.out.println(subareaSum(nums, 0));
        System.out.println(dummy(new int[] {6,4,4,2,20,5,5}, 10));
    }


    public static int subareaSum(int[] nums, int k) {
        Map<Integer,Integer> list = new HashMap<>();
        int sum =0;
        int count =0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];

            if(sum == k) {
                count++;
            }
            if (list.get(sum-k) != null) {
                count = count + list.get(sum-k);
            }
            list.put(sum, list.getOrDefault(sum,0)+1);
        }
        return count;

    }

    public static int dummy(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        //6,4,4,2,20,5,15

        while(right < nums.length) {
            sum += nums[right];
            if(sum == k) {
                count++;
                right = left;
                left++;
                sum =0 ;
            }
            while(sum > k) {
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return count;
    }

}
