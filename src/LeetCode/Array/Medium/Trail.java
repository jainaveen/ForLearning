package LeetCode.Array.Medium;

public class Trail {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));

    }

    public static int canJump(int[] nums) {

        int jumps = 0;
        int stepsLeft = nums[0]; // Steps we can take from current index
        int maxReach = nums[0];  // Maximum index we can reach

        for (int i = 1; i < nums.length - 1; i++) {
            stepsLeft--; // Reduce steps as we move forward
            maxReach = Math.max(maxReach, i + nums[i]); // Update farthest reachable index

            if (stepsLeft == 0) { // If we used up all steps in the current jump range
                jumps++;
                stepsLeft = maxReach - i; // Reset steps to the max reachable index

                if (stepsLeft <= 0) return -1; // If stuck, return failure (shouldn't happen for valid inputs)
            }
        }
        return jumps + 1; // Add final jump to reach the last index
    }
}
