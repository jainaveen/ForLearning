package DynamicProgramming.Easy;

public class CountSteps {
    public static void main(String[] args) {
        // Time complexity - O(3 power n)
        System.out.println(recursiveSteps(4));

        System.out.println(tabSteps(4));

        System.out.println(countWays(1));
    }

    static int recursiveSteps(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        return recursiveSteps(n-1) +
                recursiveSteps(n-2)+
                recursiveSteps(n-3);
    }
    static long countWays(int dist) {
        // Create the array of size 3.
        int []ways = new int[3];
        int n = dist;


        // Initialize the bases cases
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;

        // Run a loop from 3 to n
        // Bottom up approach to fill the array
        for(int i=3 ;i<=n ;i++) {
            ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3];

        }

        return ways[n%3];
    }

    static long tabSteps(int n) {
        int zero = 1;
        int first = 1;
        int second = 2;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = zero + first + second;
            zero = first;
            first = second;
            second = curr;
        }
        return curr;
    }

}
