package Backtracking.Recursion.Easy;

public class ReverseNumber {
    static int sum = 0;
    public static void main(String[] args) {
        reverse(709);
        System.out.println("Reverse Number with static variable " + sum);
        System.out.println("Reverse Without static variable " + reverseNumberRec(709,0));
        System.out.println(dummy(1234,0));
    }
    static void reverse(int k) {
        if(k == 0) {
            return;
        }
        int rem = k % 10;
        int n = k /10;
        sum = (sum * 10) + rem;
        reverse(n);
    }

    static int reverseNumberRec(int numberToReverse, int recursiveReversedNumber) {
        if (numberToReverse > 0) {
            int mod = numberToReverse % 10;
            recursiveReversedNumber = recursiveReversedNumber * 10 + mod;
            numberToReverse /= 10;
            return reverseNumberRec(numberToReverse, recursiveReversedNumber);
        }

        return recursiveReversedNumber;
    }

    static int dummy(int input, int output) {
        if(input == 0) {
            return output;
        }
        int rem  = input % 10;
        output = Integer.parseInt(output+"" +rem);
        return dummy(input/10,output);
    }
}
