package DynamicProgramming.Subsequence;

public class LongestRepeatingSubsequence {

    public int LongestRepeatingSubsequence(String str)
    {
        String str2 = str;
       return helper(str, str2);
    }

    public int helper(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int maxLen = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1) && i!=j) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return maxLen;
    }
}
