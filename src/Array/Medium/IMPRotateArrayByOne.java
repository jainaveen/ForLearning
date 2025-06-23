package Array.Medium;

import java.util.Arrays;

public class IMPRotateArrayByOne {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        rotate2(nums, 3);
    }

  //  Input: nums = [1,2,3,4,5,6,7], k = 3
  //  Output: [5,6,7,1,2,3,4]


    static void rotate2(int[] nums, int k) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[(i+k) % nums.length]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }

        System.out.println(Arrays.toString(nums));
    }


}
