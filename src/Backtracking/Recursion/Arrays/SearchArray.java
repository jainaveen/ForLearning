package Backtracking.Recursion.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SearchArray {

    public static void main(String[] args) {
        int[] arr = {1,8,9,15,3};

        //identify the index of an element from the array
        System.out.println("Search item index " + search(arr,0,9));

        int[] arr1 = {1,2,3,4,4,8};
        List<Integer> list = new ArrayList<>();

        //identify the index of an element from the array
        System.out.println("Search target index and return a list " + find(arr1,0,4, list));


        //identify the index of an element from the array
        System.out.println("Search target index  " + findIndex(arr1,0,4));

    }

    static int search(int[] arr,int index, int k) {
        if(index > arr.length-1) {
            return -1;
        }
        if(arr[index] == k) {
            return index;
        }

        return search(arr,index+1, k);

    }

    static List find(int[] arr, int sIndex, int target, List list) {
        if(sIndex == arr.length) {
            return list;
        }
        if(arr[sIndex] == target) {
            list.add(sIndex);
        }

        return find(arr,sIndex+1, target, list);
    }

    static List findIndex(int[] arr, int sIndex, int target) {
        List list = new ArrayList();
        if(sIndex == arr.length) {
            return list;
        }
        if(arr[sIndex] == target) {
            list.add(sIndex);
        }

        List<Integer> newList = findIndex(arr,sIndex+1, target );
        list.addAll(newList);
        return list;
    }
}
