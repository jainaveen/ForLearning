package Sorting_Algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        sortUsingIntegers();
        sortUsingString();
    }

    private static void sortUsingIntegers() {
        int[] arr = {5, 8, 3, 4, 1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void sortUsingString() {
        String[] words = {"zebra", "apple", "manago","banana"};

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length-i-1; j++) {
                if(words[j].compareTo(words[j+1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(words));
    }
}
