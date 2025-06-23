package Educative.TwoPointers.Medium;

public class ValidPalindromeII {

    public static void main(String[] args) {
        String text = "ABCDEFGHIJKLMNOPQRSTUVgVUTSRQPONMLKLJIHGFEDCBA";
        System.out.println(checkPalindrome(text, 0, text.length() - 1, true));
    }

    private static boolean checkPalindrome(String text, int start, int end, boolean canSkip) {
        while (start < end) {
            if (text.charAt(start) == text.charAt(end)) {
                start++;
                end--;
            } else if (canSkip) {
                // Try skipping either the left or the right character
                return checkPalindrome(text, start + 1, end, false) || checkPalindrome(text, start, end - 1, false);
            } else {
                return false; // If we already skipped once, it's not a valid palindrome
            }
        }
        return true;
    }
}
