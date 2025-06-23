package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class IMPTotalNumberOfSubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,7,1,9};
        System.out.println(subarraySum(nums, 15));

        /*
        nums = [3, 4, 7, 2, -3, 1, 4, 2], k = 7
        The subarrays are [3,4], [7], [4,7,-3,-1], and [7,2,-3,1].
         */
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if(sum == k) {
                count++;
            }
            if(map.containsKey(sum-k)) {
                count = count + map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
