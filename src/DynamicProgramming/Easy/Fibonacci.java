package DynamicProgramming.Easy;

import java.util.Arrays;

public class Fibonacci {
    //0 1 1 2 3 5 8

    //https://takeuforward.org/data-structure/dynamic-programming-introduction/
    public static void main(String[] args) {

        // Basic recursive approach
        System.out.println(recursiveFibo(6));

        //Memoization approach - Top Down approach
        //Time complexity - O(N)
        /*
        Reason: The overlapping subproblems will return the answer in constant time O(1).
        Therefore the total number of new subproblems we solve is ‘n’.
        Hence total time complexity is O(N).

        Space Complexity: O(N)
        Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
        Therefore total space complexity will be O(N) + O(N) ≈ O(N)
         */
        recursiveMemFibo(6);

        //best approach for space complexity
       // Space Complexity: O(1)
        //Reason: We are not using any extra space
        tabulationFibo(6);
    }

    static int recursiveFibo(int k) {
        if( k < 2) {
            return k;
        }
        return recursiveFibo(k-1) + recursiveFibo(k-2);
    }

    static void recursiveMemFibo(int k) {
        int[] memArr = new int[k+1];
        Arrays.fill(memArr, -1);
        System.out.println(helper(k, memArr));
    }

    static int helper(int n, int[] memArr) {
        if(n < 2) {
            return n;
        }
        if(memArr[n]!= -1) {
            return memArr[n];
        }
        return memArr[n] = helper(n-1, memArr) + helper(n-2,memArr);
    }

    static void tabulationFibo(int n) {
        int prev = 0;
        int prev2 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev2 + prev;
            prev = prev2;
            prev2 = curr;
        }
        System.out.println(curr);
    }

    static void du(int k) {
        int[] dp = new int[k+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[k]);
    }
}
