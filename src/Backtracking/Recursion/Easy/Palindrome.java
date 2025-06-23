package Backtracking.Recursion.Easy;

public class Palindrome {

    public static void main(String[] args) {
        String text = "aaaa";
        System.out.println("Palindrome: " +text+ " " + isPalindrome(text));
    }
    static boolean isPalindrome(String str) {

        if((str.length() == 0) || (str.length() == 1)) {
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindrome(str.substring(1,str.length()-1));
        }
        return false;
    }
}
