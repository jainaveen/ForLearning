package Backtracking.Recursion.Easy;

public class ClimbStairs {
    public static void main(String[] args) {
       System.out.println("Number of steps " +climbStairs(4));

        System.out.println("Number of recursion steps "+climbStairsRecursive(6));
    }
    public static int climbStairs(int n) {
        if(n <=2) {
            return n;
        }
        int[] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;

        //start from step 3
        for (int i = 3; i < step.length; i++) {
            step[i]= step[i-1]+ step[i-2];
        }
        return step[n];
    }

    public static int climbStairsRecursive(int n) {
        if(n<=2){
            return n;
        }
        int[] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;

        step[n] = climbStairsRecursive(n - 1 ) + climbStairsRecursive(n - 2);
        return step[n];
    }
}
