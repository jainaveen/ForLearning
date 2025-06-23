package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingElement {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        int[] res = new int[nums.length+1];
        for (int i = 0; i < res.length; i++) {
            if(!list.contains(i)) {
                return i;
            }
        }
        return 0;

    }
}
