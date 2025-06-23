package String.Medium;

public class PalindromePermutation {

    //https://www.youtube.com/watch?v=Pp5hdsNdqOU
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("raccecar"));
    }
    public static boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int odd = 0;
        for (int x : cnt) {
            odd += x % 2;
        }
        return odd <= 1;
    }
}
