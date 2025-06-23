package DynamicProgramming.Medium;

public class Robber2 {
    public static void main(String[] args) {
        int[] nums = {200,3,140,20,10};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] skipFirstHouse = new int[nums.length-1];
        int[] skipLastHouse = new int[nums.length-1];

        for (int i = 0; i < nums.length-1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i+1];
        }

        int maxSkipFirstHouse = robHelper(skipFirstHouse);
        int maxSkipLastHouse = robHelper(skipLastHouse);
        return Math.max(maxSkipLastHouse,maxSkipFirstHouse);
    }

    static int robHelper(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1],arr[0]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-2]+arr[i] , dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
