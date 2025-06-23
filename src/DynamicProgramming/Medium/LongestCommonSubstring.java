package DynamicProgramming.Medium;

public class LongestCommonSubstring {

    int longestCommonSubstr(String S1, String S2, int n, int m){
       int maxLen = 0;
       String res = "";
        for (int i = 0; i < S1.length(); i++) {
            res = "";
            for (int j = i; j < S1.length(); j++) {
                res = res + S1.charAt(j);
                if(S2.contains(res)) {
                    maxLen = Math.max(maxLen, res.length());
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    int dpLongestCommon(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int maxLen = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}
