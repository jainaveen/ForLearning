package DynamicProgramming.Subsequence;


import java.util.Arrays;

public class SubsetSumProblem {
    /*
    First, we need to understand what a subsequence/subset is.

    A subset/subsequence is a contiguous or non-contiguous part of an array,
    where elements appear in the same order as the original array.
    For example, for the array: [2,3,1] , the subsequences will be
     [{2},{3},{1},{2,3},{2,1},{3,1},{2,3,1}}
     but {3,2} is not a subsequence because its elements are not in the same order
     as the original array.
    */


    public  boolean isSubsetSum(int N, int nums[], int k){

        boolean[][] dp = new boolean[nums.length+1][k+1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int index = 1; index <= nums.length; index++) {
            for (int target = 1; target <=k; target++) {
                boolean not_taken = dp[index - 1][target];
                boolean taken = false;
                if (target >= nums[index-1]) {
                    taken = dp[index - 1][target - nums[index-1]];
                }
                dp[index][target] = taken || not_taken;
            }
        }

        return dp[nums.length][k];

    }

    public int countSubsetSum(int N, int nums[], int k){

        int[][] dp = new int[nums.length+1][k+1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int index = 1; index <= nums.length; index++) {
            for (int target = 1; target <=k; target++) {
                int not_taken = dp[index - 1][target];
                int taken = 0;
                if (target >= nums[index-1]) {
                    taken = dp[index - 1][target - nums[index-1]];
                }
                dp[index][target] = taken + not_taken;
            }
        }

        return dp[nums.length][k];

    }

    public boolean canPartition(int[] nums) {
        int calSum = 0;
        calSum = Arrays.stream(nums).sum();
        if(calSum % 2 !=0) {
            return false;
        }
        int sum = calSum/2;
        return isSubsetSum(nums.length,nums,sum);
    }
}
