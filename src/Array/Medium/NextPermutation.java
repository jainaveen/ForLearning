package Array.Medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums)  {
        //Identify the point of change
        int i=nums.length-2;
        while((i>=0) && nums[i] >= nums[i+1]) {
            i--;
        }
        //identify the next highest number
        if(i>=0) {
            int j = nums.length-1;
            while(j>=0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(i,j,nums);
            reverse(nums, i+1);
        }

        Arrays.stream(nums).forEach(System.out::print);
    }
    //1,4,5,1,1
    //1,4,1,1,5
    private static void reverse(int[] nums, int start) {
        int end = nums.length-1;
        while(start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    static void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
