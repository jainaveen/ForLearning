package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort0And1And2 {
    public static void main(String[] args) {

        sortColors(new int[] {2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int num : nums) {
            switch (num) {
                case 0:
                    zero.add(num);
                    break;
                case 1:
                    one.add(num);
                    break;
                case 2:
                    second.add(num);
                    break;
                default:
                    break;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(zero);
        result.addAll(one);
        result.addAll(second);

        int[] nums2 = result.stream()
                .mapToInt(i->i)
                .toArray();
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }


    }
}
