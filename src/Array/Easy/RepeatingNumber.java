package Array.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RepeatingNumber {
    public static void main(String[] args) {
      //  System.out.println(findDuplicate(new int[]{3,3,3,3}));
        System.out.println(anotherApproach(new int[] {1,2,3,4,2}));
    }

    public static int findDuplicate(int[] nums) {
        int[] arr = new int[Integer.MAX_VALUE];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >1) {
                return i;
            }
        }
        return 0;

    }

    public static int anotherApproach(int[] nums) {
        boolean[] bool = new boolean[nums.length];
        for(int num :nums) {
            if(bool[num]) {
                return num;
            }
            bool[num] = true;
        }
        return 0;
    }
}
