package Array.Easy;

import java.util.*;
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(remove_duplicate(arr));
        //System.out.println(removeDuplicates(arr));
       System.out.println(removeDuplicates2(new int[]{1,1,1,2,2,3}));
    }

    static int remove_duplicate(int arr[]) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
    public static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
