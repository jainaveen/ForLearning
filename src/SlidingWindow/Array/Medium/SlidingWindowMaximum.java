package SlidingWindow.Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int w =3;
        System.out.println(Arrays.toString(findMaxSlidingWindow(nums, w)));
    }

    public static int[] findMaxSlidingWindow(int[] nums, int w) {

        // Replace this placeholder return statement with your code
        int currVal = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<w;i++) {
            list.add(nums[i]);
        }
        list2.add(list.stream().max(Comparator.naturalOrder()).get());

        for(int i=w;i<nums.length;i++) {
            list.remove(0);
            list.add(nums[i]);
            list2.add(list.stream().max(Comparator.naturalOrder()).get());
        }
        return list2.stream().mapToInt(m->m.intValue()).toArray();
    }
}
