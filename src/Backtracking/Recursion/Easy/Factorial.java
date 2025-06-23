package Backtracking.Recursion.Easy;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial " +fac(5));
    }

    static int fac(int k) {
        if(k == 1) {
            return k;
        }
        return k * fac(k-1);
    }
}
