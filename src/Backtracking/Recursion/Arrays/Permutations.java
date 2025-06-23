package Backtracking.Recursion.Arrays;

import java.util.*;
import java.util.stream.Stream;


public class Permutations {
    //https://www.youtube.com/watch?v=vKQ6oUH02gw
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        //Use fixed index and loop through the list
        //swap the values with the fixed index
        List<List<Integer>> out = new ArrayList<>();
        recursiveArray(nums, out, 0);
        System.out.println(out);

        List<List<String>> list = new ArrayList<>();
        String str = "abc";
        recursiveString(str.toCharArray(), list, 0);
        System.out.println(list);

    }

    private static void recursiveArray(int[] nums, List<List<Integer>> result, int fixedIndex) {
        if (fixedIndex == nums.length) {
            List<Integer> list= Arrays.stream(nums).boxed().toList();
            if(!result.contains(list)) {
                result.add(list);
            }
        }
        Set<Integer> st = new HashSet<>();
        for (int i = fixedIndex; i < nums.length; i++) {
            if(st.contains(nums[i]))continue;
            st.add(nums[i]);
            swap(nums,fixedIndex,i);
            recursiveArray(nums, result, fixedIndex+1);
            swap(nums,fixedIndex,i);
        }
    }
    public static void swap(int [] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    private static void recursiveString(char[] arr, List<List<String>> result, int fixedIndex) {
        if(fixedIndex == arr.length-1) {
            List<String> list= Stream.of(String.valueOf(arr)).toList();
            if(!result.contains(list)) {
                result.add(list);
            }
            return;
        }
        for (int i = fixedIndex; i < arr.length; i++) {
            swap2(arr, fixedIndex,i);
            recursiveString(arr,result,fixedIndex+1);
            swap2(arr, fixedIndex,i);
        }
    }

    static void swap2(char[] text, int fixedIndex, int b) {
        char temp = text[fixedIndex];
        text[fixedIndex] = text[b];
        text[b] = temp;
    }


}
