package Backtracking.Recursion.Arrays;

public class SortedArray {

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,9};
        //check whether its sorted or not
        System.out.println("is Array sorted " + isSortedArr(arr,0,arr.length-1));
    }

    private static boolean isSortedArr(int[] arr, int i, int l) {
        if(i == l) {
            return true;
        }

        if(arr[i] < arr[i+1]) {
           return isSortedArr(arr,i+1, l);
        }
        return false;
    }
}
