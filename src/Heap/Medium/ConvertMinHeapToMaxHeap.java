package Heap.Medium;

import java.util.Arrays;

public class ConvertMinHeapToMaxHeap {
    static int[] arr = {2, 5, 10, 11, 20, 17};
  //  static int[] arr = {1,2,3,4};
    public static void main(String[] args) {
        for (int i = arr.length-1; i >=0; i--) {
            heapify(i);
        }
        System.out.println("Heapify " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            downify(i);
        }
        System.out.println("Downify " + Arrays.toString(arr));
    }

    public static void swap(int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    public static int parent(int index) {
        return (index - 1) / 2;
    }

    public static void heapify(int index) {
        if(index == 0) {
            return;
        }
        int p = parent(index);
        if(arr[index] > arr[p] ) {
            swap(index, p);
            heapify(p);
        }
    }
    private static int left(int index) {
        return 2 * index + 1;
    }

    private static int right(int index) {
        return 2 * index + 2;
    }
    public static void downify(int index) {
        int max = index;
        int left = left(index);
        int right = right(index);
        boolean flagLeft = false;
        boolean flagRight = false;
        if(left < arr.length && arr[index] < arr[left]) {
            max = left;
            flagLeft = true;
        }
        if(right < arr.length && arr[index] < arr[right]) {
            max = right;
            flagRight = true;
        }

        if(flagLeft && flagRight && arr[left] ==  arr[right]) {
            max = left;
        }

        if(max != index) {
            swap(max,index);
            downify(max);
        }
    }

}
