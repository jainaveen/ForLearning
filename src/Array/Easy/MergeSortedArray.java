package Array.Easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        System.out.println("merge " + Arrays.toString(merge()));

    }

    public static int[] merge() {
       int[] nums1 = {1,2,3,0,0,0};
       int m = 3;
       int[] nums2 = {2,5,6};
       int n = 3;
       int[] res = new int[m+n];
       int i = 0;
       int j = 0;
       int c =0;

       while(i < m && j < n) {
           if(nums1[i] <= nums2[j]) {
               res[c] = nums1[i];
               i++;
           } else {
               res[c] = nums2[j];
               j++;
           }
           c++;
       }
       while(j < nums2.length) {
           res[c] = nums2[j];
           j++;
           c++;
       }

       return res;


    }
}

