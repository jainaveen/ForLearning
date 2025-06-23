package Backtracking.Recursion.Strings;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class PermutationsII {
    public void permutationsStringArray(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permutationHelper(arr,0, list);
        System.out.println(list);
    }

    public void permutationHelper(int[] arr, int fixedIndex, List<List<Integer>> list) {
        if(fixedIndex == arr.length-1) {
            List<Integer> sub= new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                sub.add(arr[i]);
            }
            list.add(sub);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = fixedIndex; i < arr.length; i++) {
            if(set.contains(arr[i]))
                continue;
            set.add(arr[i]);
            swap(arr, i, fixedIndex);
            permutationHelper(arr,fixedIndex+1, list);
            swap(arr, i, fixedIndex);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
