package Array.Easy;

import java.util.*;
import java.util.stream.Stream;

public class FlippingAnImage {
    public static void main(String[] args) {

        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] result = flipAndInvertImage(image);

        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15},9)));
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int[][] pro = new int[image.length][image.length];
        for (int i = 0; i < image.length; i++) {
            image[i] = reverse(image[i]);
        }
        for (int i = 0; i < image.length; i++) {
            image[i] = flip(image[i]);
        }
        return image;
    }

    public static int[] reverse(int[] val) {
        int[] res = new int[val.length];
        int j = 0;
        for (int i = val.length-1; i >=0 ; i--) {
            res[j] = val[i];
            j++;
        }
        return res;
    }
    public static int[] flip(int[] val) {
        for (int i = 0; i < val.length ; i++) {
            if(val[i] == 0) {
                val[i] = 1;
            } else if (val[i] == 1) {
                val[i] = 0;
            }
        }
        return val;
    }

    public static int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pairIdx.containsKey(target - num)) {
                return new int[] { pairIdx.get(target - num),i };
            }
            pairIdx.put(num, i);
        }

        return new int[] {};
    }
}
