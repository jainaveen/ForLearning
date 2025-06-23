package Backtracking.Recursion.Easy;

public class NumberRecursion {

    public static void main(String[] args) {
       // print(1);
        printReverse(16);
    }

    static void print(int n) {
        if(n == 6) {
            return;
        }
        System.out.println(n);
        print(n+1);
    }

    static void printReverse(int n) {
        if(n == 0) {
            return;
        }
        printReverse(n-1);
        System.out.println(n);
    }
}
