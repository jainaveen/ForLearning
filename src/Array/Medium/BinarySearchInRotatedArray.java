package Array.Medium;

public class BinarySearchInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);
        System.out.println("Target found at index: " + result);
    }

    /*
    Time Complexity: The time complexity is O(logn), since we are performing binary search, which reduces the search space by half at each step.
    Space Complexity: The space complexity is O(1), as we are only using a constant amount of extra space.
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid == target) {
                return mid;
            }

            // Determine which part of the array is sorted
            if (nums[low] <= nums[mid]) { // Left part is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Search in the left part
                } else {
                    low = mid + 1; // Search in the right part
                }
            } else { // Right part is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Search in the right part
                } else {
                    high = mid - 1; // Search in the left part
                }
            }
        }
        return -1;
    }
}
