package DynamicProgramming.Medium;

public class EditDistance {
    public int minDistance(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int minLen = 0;

        //set insert and delete in row and columns
        //delete oper for rows
        for (int i = 0; i <=text1.length(); i++) {
            dp[i][0] = i;
        }
        //insert oper for colums
        for (int i = 0; i <= text2.length() ; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= text1.length(); i++) {

            for (int j = 1; j <= text2.length(); j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
                   // minLen = dp[i][j];
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }
}
