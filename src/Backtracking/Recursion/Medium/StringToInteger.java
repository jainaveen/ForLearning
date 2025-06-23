package Backtracking.Recursion.Medium;

public class StringToInteger {
    static double result;
    public static void main(String[] args) {
        System.out.println(atoi("702"));
        System.out.println(reverseLogic("702"));
        System.out.println(atoiHelper("1a23"));
    }
    static int atoi(String str) {
        if (str.length() == 1) {
            if(str.charAt(str.length()) >= '0' && str.charAt(str.length()) <= '9') {
                return 0;
            } else {
                return -1;
            }
        }

        // trim white spaces
        str = str.trim();

        // check negative or positive
        int i = 0;
        // Flag to indicate if the number is negative
        boolean isNegative = str.startsWith("-");
        // Flag to indicate if the number is positive
        boolean isPositive = str.startsWith("+");
        if (isNegative) {
            i++;
        } else if (isPositive) {
            i++;
        }

        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        result = isNegative ? -result : result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    static int reverseLogic(String str) {


        if(str == null || str.length() ==1) {
            return 0;
        }
        // trim white spaces
        str = str.trim();

        // Flag to indicate if the number is negative
        boolean isNegative = str.startsWith("-");
        int result = 0;
        if(isNegative) {
            result = helper(str.substring(1));
        } else {
            result = helper(str);
        }


        if(result >= 0) {
            return isNegative ? result * -1 : result;
        }

       return -1;


    }

    static int helper(String str) {
        if(str.length() ==1) {
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                return str.charAt(0)-'0';
            } else {
                return -1;
            }
        }

        int ans = helper(str.substring(0,str.length()-1));
        if(str.charAt(str.length()-1) >= '0' && str.charAt(str.length()-1) <= '9') {
            int last = str.charAt(str.length()-1)-'0';
            return ans*10 + last;
        }
        return -1;

    }

    static int atoiHelper(String str) {
        str = str.trim();
        boolean negative = false;
        int j =0;
        if(str.startsWith("-")) {
            negative = true;
            j=1;
        }
        int[] a = new int[str.length()];
        int ans = 0;
        for (int i = j; i < str.length(); i++) {
            int v = str.charAt(i)-'0';
            if(!(v >= 0 && v <= 9)) {
                return -1;
            } else {
                ans = Integer.parseInt(ans+ "" + v + "");
            }
        }
        int i = negative == true ? -1 * ans : 1 * ans;
        return i;
    }

}
