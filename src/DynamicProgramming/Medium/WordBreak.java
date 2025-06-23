package DynamicProgramming.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i-1; j++) {
                String text = s.substring(j,i);
                if(dp[j] && set.contains(text)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
