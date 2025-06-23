package DynamicProgramming.Medium;

public class KnapsackProblem {

    //https://www.youtube.com/watch?v=nLmhmB6NzcM
    public int knapSack(int W, int wt[], int val[], int n)  {
        // your code here

        int[][] dp = new int[wt.length+1][W+1];

        for (int index = 1; index <= wt.length; index++) {
            for (int target = 1; target <= W; target++) {
                dp[index][target] = dp[index - 1][target];
                if(target >= wt[index-1]) {
                    dp[index][target] = Math.max(dp[index-1][target],
                            dp[index-1][target-wt[index-1]]+val[index-1]);
                }
            }
        }
        return dp[wt.length][W];
    }
}
