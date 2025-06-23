package Array.Medium;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
      System.out.println(canJump(new int[]{2,3,1,1,4}));
      System.out.println(jumpII(new int[]{2,4,1,2,3,1,1,2}));

    }

    public static boolean canJump(int[] nums) {
        int stepsLeft = nums[0]; // Initialize stepsLeft with the first element

        for (int i = 1; i < nums.length; i++) {
            // Decrease the stepsLeft because we are moving to the next index
            stepsLeft--;

            // If stepsLeft becomes negative, it means we can't reach the next index
            if (stepsLeft < 0) {
                return false;
            }

            // If we are at the last index, we can reach the end
            if (i == nums.length - 1) {
                return true;
            }

            // If the current value in nums can let us jump further, update stepsLeft
            if (stepsLeft < nums[i]) {
                stepsLeft = nums[i];
            }
        }
        return true;
    }


    public static int jumpII(int[] nums) {
        int totalJumps = 0;

        // destination is last index
        int destination = nums.length - 1;

        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1) return 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < nums.length; i++) {

            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we reached destination already
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }

}