package Array.Easy;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,1,2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        //another approach
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

    // it took 6ms
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] res;
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 =Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Set<Integer> result = set1.stream()
                .filter(item->set2.contains(item)).collect(Collectors.toSet());

        res = result.stream().mapToInt(m->m.intValue()).toArray();
        return res;
    }

    //took 2ms
    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> one = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            one.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            if(one.contains(nums2[j])){
                ans.add(nums2[j]);
            }
        }
        return ans.stream()
                .mapToInt(m->m.intValue())
                .toArray();
        //return arr;
    }
}
