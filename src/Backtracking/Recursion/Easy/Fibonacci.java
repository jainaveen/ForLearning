package Backtracking.Recursion.Easy;

public class Fibonacci {

    public static void main(String[] args) {
        //fibonacci(6);
        // 0 , 1, 1 , 2 , 3, 5, 8, 13 .......
        System.out.println();

        System.out.println(recursiveFibonacci(7));

    }

    static int fibonacci(int k) {
        System.out.print(0);
        System.out.print("," + 1);
        int past = 0;
        int last = 1;
        int current = 0;
        for (int i = 1; i < k; i++) {
            current = past + last;
            System.out.print("," + current);
            past = last;
            last = current;
        }
        return current;
    }

    static int recursiveFibonacci(int k) {
        if (k < 2) {
            return k;
        }

        return recursiveFibonacci(k - 1) + recursiveFibonacci(k - 2);
    }

}
