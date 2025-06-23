package String.Easy;

public class Palindrome {
    public static void main(String[] args) {
        //Approach 1
        System.out.println("This is a " + palindrome(515) + " palindrome");
        //Approach 2
        System.out.println("This is a " + palindromeString(551) + " palindrome using String");

        palindrome1000(1000);

        System.out.println(validPalindrome("race a car"));
    }

    private static boolean validPalindrome(String text) {
        String val = text.replaceAll("\\s", "");
        int i = 0;
        int k = val.length()-1;
        while(i < k) {
            if(val.charAt(i) != val.charAt(k)) {
                return false;
            }
            i++;
            k--;
        }
        return true;
    }

    private static boolean palindromeString(int i) {
        String num1 = Integer.toString(i);
        String num2 = new StringBuilder(i).reverse().toString();
        return num1.equals(num2);
    }

    private static boolean palindrome(int num) {
        int originalNum = num;
        int remainder;
        int reverseNum = 0;
        while(num !=0) {
            remainder  = num % 10;
            reverseNum = reverseNum * 10 + remainder;
            num = num/10;
        }
        return reverseNum ==  originalNum ;

    }

    private static void palindrome1000(int num) {
        for (int i = 11; i < num; i++) {
            int curr = i;
            int rev = 0;
            while(curr != 0) {
                int remainder = curr % 10;
                rev = rev * 10 + remainder;
                curr = curr / 10;
            }
            if(i == rev) {
                System.out.println(i);
            }
        }
    }
}
