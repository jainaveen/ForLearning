package Backtracking.Recursion.Easy;

public class PrintNum {
    public static void main(String[] args) {
        printNos(10);
    }
    public static void printNos(int N)
    {
        int s = (N-1) % N;
        System.out.println(s);
    }
}
