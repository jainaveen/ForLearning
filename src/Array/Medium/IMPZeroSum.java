package Array.Medium;

import java.util.Arrays;

public class IMPZeroSum {

    public static void main(String[] args) {
        //https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
        /*
        Example 1:
        Input: n = 5
        Output: [-7,-1,1,3,4]
        Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

        Example 2:
        Input: n = 3
        Output: [-1,0,1]

        Example 3:
        Input: n = 1
        Output: [0]

         */
        System.out.println(Arrays.toString(sumZero(5)));
    }

    public static int[] sumZero(int n) {
        int[] result  = new int[n];
        int index = 0;
        if(n % 2 != 0) {
            result[index++] = 0;
            n--;
        }

        for(int i = 1; i <= n/2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }
        return result;
    }
}
