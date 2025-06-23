package Array.Medium;

import java.io.ByteArrayOutputStream;
import java.util.*;

public class LenOfLongestSubarraywithEqualNumbersof0sand1s {

    public static void main(String[] args) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = bos.toByteArray();

        if (bytes == null || bytes.length == 0) {
            System.out.println("Byte array is empty");
        }

        int[] nums = {0, 0,1,0,0,0,1,1};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Base case to handle full array case
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1
            prefixSum += (nums[i] == 0) ? -1 : 1;

            // If this prefix sum was seen before, update max length
            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // Store the first occurrence of this prefix sum
                map.put(prefixSum, i);
            }
        }
        System.out.println("Length of Longest subarray " + maxLength);

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1));  // Output: 4
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            // Only start counting if it's the smallest number in the sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }

}
