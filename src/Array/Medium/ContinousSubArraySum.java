package Array.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContinousSubArraySum {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 24, 36);
        System.out.println(checkSubarraySum(list, 36));
    }

    public static boolean checkSubarraySum(List<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1); // Important to handle the use where the subarray starts from zero
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            int remainder = sum % k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
