package String.Easy;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToDecimal("XIX"));
    }

    public static int romanToDecimal(String str) {
        // code here
        int curr =0;
        int sum=0;
        int next =0;
        if(str.length() == 1) {
            return romanValues(str.charAt(0));
        } else if (str.length() ==2) {
            char c = str.charAt(0);
            char cn = str.charAt(1);

            curr = romanValues(c);
            next =  romanValues(cn);
            if(curr < next) {
                sum = next - curr;
            } else {
                sum = curr + next;
            }
            return sum;
        }
        int  i = 0;
        while (i < str.length()-1) {
            char c = str.charAt(i);
            char cn = str.charAt(i+1);

            curr = romanValues(c);
            next =  romanValues(cn);
            if(curr >= next) {
                sum = sum + curr; //10
                i++;
            } else if(curr < next) {
                sum = sum + (next - curr);
                i=i+2;
            }

        }
        if (i < str.length()) {
            sum += romanValues(str.charAt(str.length()-1));
        }

        return sum;
    }

    static int romanValues(Character c) {
        int curr = 0;
        switch (c) {
            case 'I':
                curr =1;
                break;
            case 'V':
                curr = 5;
                break;
            case 'X':
                curr = 10;
                break;
            case 'L':
                curr = 50;
                break;
            case 'C':
                curr = 100;
                break;
            case 'D':
                curr = 500;
                break;
            case 'M':
                curr = 1000;
                break;

        }
        return curr;
    }
}
