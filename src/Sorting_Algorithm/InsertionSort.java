package Sorting_Algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12,54,32,5,15};
        int[] result = insertionSort(arr);
        System.out.println(Arrays.toString(result));
    }
    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > element) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
        return arr;
    }
}
