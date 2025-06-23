package Sorting_Algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,5,3, 1, 8, 7, 2, 4};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex-1);
            quickSort(arr, pivotIndex+1, end);

        }

    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start -1;
        for (int j = start; j <= end -1 ; j++) {
            if(arr[j] <= pivot) {
                i++;
                int ival = arr[i];
                int jval = arr[j];
                arr[i] = jval;
                arr[j] = ival;
            }
        }
        int ival = arr[i+1];
        arr[end] = ival;
        arr[i+1] = pivot;
        return i+1;
    }
}
