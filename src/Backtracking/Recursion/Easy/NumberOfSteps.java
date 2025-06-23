package Backtracking.Recursion.Easy;

public class NumberOfSteps {

    public static void main(String[] args) {

        System.out.println("Step count to zero " + helper(14,0));
    }


    private static int helper(int n, int count) {
        if(n==0) {
            return count;
        }

        if(n%2==0){
            return helper(n/2,count+1);
        }
        return helper(n-1,count+1);
    }

}
