package SlidingWindow.Array.Medium;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {1,2,7,3,4,5};
        //System.out.println(minSubArrayLen(7,nums));
        System.out.println(test(10, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize= 1000000;
        int maxLen = 0;
        int totalValue =0;
        for (int left =0 ,right = 0; right < nums.length; right++) {
            totalValue = totalValue + nums[right];
            while(totalValue >= target) {
                minSize = Math.min(minSize,right - left + 1);
                maxLen = Math.max(maxLen, right-left + 1);
                totalValue = totalValue - nums[left];
                left++;
            }
        }
        System.out.println("maximum len " + maxLen);
        return minSize == 1000000 ?0 : minSize;
    }

    public static int test(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum = sum + nums[right];

            while (sum >target) {

                sum = sum - nums[left++];
            }

            if(sum == target) {
                minLen = Math.min(minLen, right - left + 1);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ?0 : minLen  ;
    }


}
