package Sorting_Algorithm;

import java.util.Arrays;

public class SelectionSort {
    //best case - O(n^2)
    //worst case - O(n^2)


    public static void main(String[] args) {
        int[] arr = {12,54,32,5,15};
        int[] result = selectionSort(arr);
        //int[] result = selectionSort2(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            int swap = arr[min];
            arr[min] = arr[i];
            arr[i] = swap;
        }
        return arr;
    }

    static int[] selectionSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j] > curr) {
                    int swap = arr[j];
                    arr[j] = curr;
                    arr[j+1] = swap;
                } else {
                    arr[j+1] = curr;
                }
            }
        }
        return arr;
    }

}
