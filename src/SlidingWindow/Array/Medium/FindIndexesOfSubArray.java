package SlidingWindow.Array.Medium;

import java.util.ArrayList;

    public class FindIndexesOfSubArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,7,5};
        int n = 5;
        int s = 5;

        System.out.println(findIndexes(arr,n,s));

    }

    static ArrayList<Integer> findIndexes(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        int calSum = arr[0];
        int i = 0 ,j =0;
        while (i < arr.length) {
            if(calSum == s) {
                list.add(j+1);
                list.add(i+1);
                return list;
            }
            if(calSum < s) {
                i++;
                calSum += arr[i];
            }

            if (calSum > s) {
                calSum -= arr[j];
                j++;
            }
        }
        if(list.isEmpty()) {
            list.add(-1);
        }
        return list;
    }
}
