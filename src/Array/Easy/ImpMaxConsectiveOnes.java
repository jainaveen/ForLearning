package Array.Easy;

public class ImpMaxConsectiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println("Max consecutive " + findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int val : nums){
            if(val == 1){
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}
