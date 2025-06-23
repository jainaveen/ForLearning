package Array.Easy;

import java.util.*;

public class IMPMajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        // Best solution
        System.out.println(majorityElement(nums));

        System.out.println(majorityElementII(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        // Boyer-Moore Voting Algorithm
        // 1st pass: Find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // Set new candidate
            }
            count += (num == candidate) ? 1 : -1;
        }
// 2nd pass: Verify if the candidate is actually a majority element
        count = 0;
        for(int num : nums) {
            if( candidate == num) {
                count++;
            }
        }
        return count > nums.length /2 ? candidate : -1;
    }
    public static List<Integer> majorityElementII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxVal = nums.length/3;
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if(entry.getValue() > maxVal) {
                list.add(entry.getKey());
            }
        }
        return list;
    }


}
