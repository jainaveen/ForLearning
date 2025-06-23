package Subsequence.Easy;

public class IsSubsequence {

    public static void main(String[] args) {
       String s = "abracadabra";
       String t = "abra";
       System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0; // Pointers for s and t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++; // Move pointer in t if characters match
            }
            i++; // Always move pointer in s
        }

        return j == t.length(); // If j reached end of t, t is a subsequence of s
    }
}
