package Backtracking.Recursion.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {



    public void permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutations(f+ch+s,up.substring(1));
        }
    }



    public void permutationsStringArray(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permutationHelper(arr,0, list);
        System.out.println(list);
    }

    public void permutationHelper(int[] arr, int fixedIndex, List<List<Integer>> list) {
        if(fixedIndex == arr.length-1) {
            List<Integer> sub=new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++){
                sub.add(arr[i]);
            }
            list.add(sub);
            return;
        }

        for (int i = fixedIndex; i < arr.length; i++) {
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
