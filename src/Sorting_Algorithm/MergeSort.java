package Sorting_Algorithm;

import java.util.Arrays;
import java.util.Collections;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 54, 32, 5, 15};
        int[] res = mergeSort(arr);

        System.out.println(Arrays.toString(res));

    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int middleIndex = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, middleIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, middleIndex, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            res[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            res[k] = right[j];
            j++;
            k++;
        }


        return res;
    }
}
