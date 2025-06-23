package Array.Medium;

import java.util.*;

public class IMPTwoSum {

    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,7,8,9};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
        threeSum();
        threeSumTest();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] res = new int[2];
        while(left< right) {
            if(numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
           if(numbers[left] + numbers[right] < target) {
               left++;
           } else {
               right--;
           }
        }
        return res;
    }

    public static void threeSum() {
       int[] nums = {-2,0,0,2,2};
        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while(left< right) {
              int sum =  nums[i] + nums[left] + nums[right];
                if( sum == 0) {
                    lists.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                }
                if(sum < 0) {
                    left++;
                } else {
                    right --;
                }
            }
        }
        System.out.println(lists.stream().toList());
    }

   public static void threeSumTest(){
      int[] nums = {-1, -1, 0, 1, 2};
      Arrays.sort(nums);
      List<List<Integer>> listList = new ArrayList<>();
       for (int i = 0; i < nums.length; i++) {

           int first = nums[i];
           int right = nums.length-1;
           int left = i+ 1;
           while(left< right) {
               if (first + nums[left] + nums[right] == 0) {
                   listList.add(List.of(first, nums[left], nums[right]));
                   break;
               } else if (first + nums[left] + nums[right] < 0) {
                   left++;
               } else {
                   right--;
               }

           }
       }
       System.out.println(listList);
   }

}
