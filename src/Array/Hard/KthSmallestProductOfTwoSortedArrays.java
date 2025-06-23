package Array.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KthSmallestProductOfTwoSortedArrays {

    public static void main(String[] args) {
        int b = -1 * -1;
        int[] nums1 = {-100000,100000};
        int[] nums2 = {-100000,100000};
        int k = 3;
        System.out.println(kthSmallestProduct(nums1,nums2,k));

    }

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < nums1.length; i++) {
            for (long j = 0; j < nums2.length; j++) {
                list.add((long) (nums1[(int) i] * nums2[(int) j]));
            }
        }
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get((int) (k-1));

    }
}
