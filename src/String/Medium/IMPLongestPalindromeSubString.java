package String.Medium;

public class IMPLongestPalindromeSubString {

    public static void main(String[] args) {
        System.out.println("Longest Palindrome SubString " + anotherApproach("babad"));


    }

    public static String longestPalindromeSubString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String input = s.substring(i, j + 1);
                    if (palindrome(input)) {
                        res = res.length() < input.length() ? input : res;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static boolean palindrome(String str) {
        int i=0,j=str.length()-1;
        while(i<=j) {
            if(str.charAt(i)==str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String anotherApproach(String s) {
        if (s == null || s.length() < 1) return "";

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            String odd = expandAroundCenter(s, i, i);
            // Even-length palindromes
            String even = expandAroundCenter(s, i, i + 1);

            // Update the result with the longer palindrome
            if (odd.length() > res.length()) res = odd;
            if (even.length() > res.length()) res = even;
        }
        return res;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


}
