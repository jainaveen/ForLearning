package BinarySearch;

import java.util.Arrays;

public class ImpFindFirstAndLastPosition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,8,9,9,10}, 9)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
      //  result[0] = findFirst(nums, target);
        result[0] = findIndex(nums, target, true);
        result[1] = findIndex(nums, target, false);
        return result;
    }

    private static int findIndex(int[] nums, int target, boolean firstIndex) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                index = mid;
                if (firstIndex) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
