package DynamicProgramming.Subsequence;

import DynamicProgramming.Medium.EditDistance;
import DynamicProgramming.Medium.LongestPalindromeSubString;

public class Demo {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("longest common subsequence " + lcs.longestCommonSubsequence("abcde", "aec"));

        LongestPalindromeSubString lps = new LongestPalindromeSubString();
        System.out.println("longest palindrome substring " +lps.longestPalindrome("cbbd"));

        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        System.out.println("longest repeating subsequence " +lrs.LongestRepeatingSubsequence("axxzxy"));

        SubsetSumProblem ss = new SubsetSumProblem();
        System.out.println("Subset problem " + ss.isSubsetSum(6,new int[]{3, 34, 4, 12, 5, 2},30));

        System.out.println("Count of Subset problem " + ss.countSubsetSum(5,new int[]{2,5,1,4,3},10));

        System.out.println("Partition equal to Subset problem " + ss.canPartition(new int[]{3, 34, 4, 12, 5, 2}));

        LengthOfLongestSubsequence lls = new LengthOfLongestSubsequence();
        System.out.println("Length of Longest Subsequence " + lls.lengthOfLIS(new int[]{2,2,2,2,2}));
    }
}
