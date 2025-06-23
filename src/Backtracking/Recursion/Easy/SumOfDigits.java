package Backtracking.Recursion.Easy;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println("Sum of digits " + sum(456225));
        System.out.println(dummy(456225));
    }

    static int sum(int k) {
        if(k ==0){
            return 0;
        }
        int rem = k % 10;
        k = k /10;
        return rem + sum(k);
    }


    static int dummy(int n) {
        if(n <= 0) {
            return 0;
        }
        int rem = n % 10;

        return rem + dummy(n/10);
    }
}
