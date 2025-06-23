package DynamicProgramming.Medium;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromeSubString {

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String input = s.substring(i, j + 1);
                    if (palindrome(input)) {
                        res = res.length() < input.length()
                                ? input : res;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static boolean palindrome(String str) {
        int i=0,j=str.length()-1;
        while(i<j) {
            if(str.charAt(i)==str.charAt(j)) {
                i++;j--;
            } else {
                return false;
            }
        }
        return true;
    }

}
