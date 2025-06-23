package Backtracking.Recursion.Easy;

public class CountZeros {
    static int count=0;
    public static void main(String[] args) {
        int value = 0100;
        countZeros(value);
        System.out.println("Count of zeros " + count );
    }

    static void countZeros(int n ) {
        int rem = n % 10;
        if(n == 0) {
            return ;
        }
        if(rem == 0) {
            count++;
        }

        countZeros(n/10);
    }

}
