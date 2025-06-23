package Backtracking.Recursion.Easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,55,66,77};
        int target = 77;
        System.out.println("Binary search index for the target:- " +  binarySearch(
                arr, target, 0, arr.length-1));
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middle = start + (end - start)/2;
        if(arr[middle] == target) {
            return middle;
        }
        if(target > arr[middle]) {
           return  binarySearch(arr, target, middle +1 , end);
        }
        return binarySearch(arr, target, start, middle-1);
    }
}
