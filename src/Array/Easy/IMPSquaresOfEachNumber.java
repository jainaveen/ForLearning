package Array.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IMPSquaresOfEachNumber {

    /*
    Given an integer array nums sorted in non-decreasing order,
    return a new array with the squares of each number, sorted in non-decreasing order.
     */

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};

        int l_ind =  0;
        int r_ind = arr.length-1;
        int index = r_ind;
        int[] res = new int[arr.length];

        while(l_ind < r_ind) {
            int lValue =  arr[l_ind] * arr[l_ind];
            int rValue = arr[r_ind] * arr[r_ind];

            if(lValue > rValue) {
                res[index] = lValue;
                l_ind++;
                index--;
            } else {
                res[index] = rValue;
                r_ind--;
                index--;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
