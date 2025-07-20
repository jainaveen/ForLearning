package BinarySearch;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,7,8};
        int left = 0;
        int right = nums.length -1 ;

        while(left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Missing number " + (left+1));
    }
}
