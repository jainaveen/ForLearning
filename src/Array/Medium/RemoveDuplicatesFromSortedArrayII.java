package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
        removeDuplicates2(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int st = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[st]);

        for(int i=1;i< nums.length;i++) {
            if(nums[i-1] != nums[i]) {
                st++;
                list.add(nums[i]);
            }
        }
        System.out.println(list);
        return 1;
    }

    public static void removeDuplicates2(int[] nums) {
        int count = 1;
        int prev = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(prev  == nums[i] && count ==1) {
                count++;
                nums[k++] = nums[i];
            } else if(nums[i-1] != nums[i]) {
                count = 1;
                nums[k++] = nums[i];
                prev = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
