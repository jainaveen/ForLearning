package String.Medium;

public class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("ulacfd","jizalu"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        return split(a, b) || split(b, a);
    }

    private static boolean split(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
      //  if (left >= right) return true;
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
