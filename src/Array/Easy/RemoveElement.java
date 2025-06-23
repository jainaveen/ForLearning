package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val =2;
      System.out.println("remove element " + removeElement(nums,val));
    }

    public static int removeElement(int[] nums, int val) {
        int k =0;
        for(int i=0;i< nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}
