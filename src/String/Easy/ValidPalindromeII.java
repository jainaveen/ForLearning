package String.Easy;

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println("ValidPalindrome " + validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // remove left character and check whether its palindrone
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0,left)).append(s.substring(left+1,s.length()));
                boolean flag = isPalindrome(sb.toString());
                if(!flag) {
                    StringBuilder sb1 = new StringBuilder(s);
                    sb1.append(sb1.substring(0,left+1)).append(sb1.substring(right,s.length()));
                    return isPalindrome(sb1.toString());
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length()-1;
        while(left < right) {
            if(text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
