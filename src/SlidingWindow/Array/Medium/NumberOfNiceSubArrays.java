package SlidingWindow.Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
       // System.out.println(anotherApproach(new int[]{2044,96397,50143},1));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        //Optimal Solution T.C.: O(N), S.C.: O(N)
        int n = nums.length;

        int i=0;

        //Updating even to 0 and odd to 1
        while(i!=n){
            if(nums[i]%2!=0)
                nums[i]=1;
            else
                nums[i]=0;
            i++;
        }


        //Simple use count subarray with sum K problem logic.

        int count =0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;

        i=0;
        while(i!=n){
            sum+=nums[i];
            if(sum==k) {
                count++;
            }

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
            i++;
        }
        return count;
    }
   /*

    public static int anotherApproach(int[] nums, int k) {
        int i = 0;

        //Updating even to 0 and odd to 1
        while (i != nums.length) {
            if (nums[i] % 2 != 0)
                nums[i] = 1;
            else
                nums[i] = 0;
            i++;
        }
        int wSum = 0;
        int mSum = Integer.MIN_VALUE;
        // Nice approach
        for (int j = 0; j < k; j++) {
            wSum += nums[j];
        }
        int left = 0;
        for (int m = k; m < nums.length; m++) {
            wSum -= nums[left];
            wSum += nums[m];// 4 - 6 + 91 =89.. 89-(-9) + 4 =102
            left++;
        }
        return mSum;
    }

     */
}
