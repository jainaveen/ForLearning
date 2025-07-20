package BinarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("search index " + search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index = 0;
        while(start <= end) {
            int mid = start + (end-start) / 2 ;
            if(nums[mid] >= nums[start]) {
                if(nums[start] <= target && target <=nums[mid]) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            } else {
                if(nums[mid] <= target && target <=nums[end]) {
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
/*
    public static int binarySearchRotated(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {
            // Finding the mid using integer division
            int mid = start + (end - start) / 2;
            // Target value is present at the middle of the array
            if (nums.get(mid) == target)
                return mid;
            // start to mid is sorted
            if (nums.get(start) <= nums.get(mid)) {
                if (nums.get(start) <= target && target < nums.get(mid)) {
                    end = mid - 1; // target is within the sorted first half of the array
                } else {
                    start = mid + 1; // target is not within the sorted first half, so let’s examine the unsorted second half
                }
            }
            // mid to end is sorted
            else {
                if (nums.get(mid) < target && target <= nums.get(end))
                    start = mid + 1; // target is within the sorted second half of the array
                else
                    end = mid - 1; // target is not within the sorted second half, so let’s examine the unsorted first half
            }
        }
        return -1;
    }
    
 */
}
