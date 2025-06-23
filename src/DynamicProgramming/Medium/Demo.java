package DynamicProgramming.Medium;


import java.util.List;

public class Demo {

    public static void main(String[] args) {

        String text = "applepenapple";
        System.out.println(text.replace("apple",""));

        LongestPalindromeSubString lps = new LongestPalindromeSubString();
        System.out.println(lps.longestPalindrome("cbbd"));

        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.longestCommonSubstr("ABCDGH","ACDGHR", 6, 6));

        System.out.println(lcs.dpLongestCommon("ABCDGH","ACDGHR"));

        EditDistance ed = new EditDistance();
        System.out.println("Minimum distance " + ed.minDistance("distance","springbok"));

        WordBreak wb = new WordBreak();
        System.out.println("is wordBreak " + wb.wordBreak("abcdef",List.of("ab","cd","ef")));

        KnapsackProblem kp = new KnapsackProblem();
        System.out.println("Knapsack problem " + kp.knapSack(4,new int[]{4,5,1},new int[]{1,2,3},3));
    }
}
