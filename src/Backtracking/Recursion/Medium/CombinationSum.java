package Backtracking.Recursion.Medium;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {

        int[] arr = {2,3,5};
        System.out.println(combinationSum(arr,8));

        int[] arrii = {10,1,2,7,6,1,5};
        System.out.println(combinationSumII(arrii,8));

        System.out.println(combinationSumIII(3, 9));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target,list,temp,0);
        return list;
    }

    public static void helper(int[] arr, int sum, List<List<Integer>> list,List<Integer> temp, int start) {
        if(sum < 0) {
            return;
        } else if(sum == 0) {
            list.add(new ArrayList<>(temp));
            return;
        } else {

            for (int i = start; i < arr.length; i++) {
                temp.add(arr[i]);
                helper(arr, sum - arr[i], list, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helperII(candidates, target,list,temp,0);
        return list;
    }

    public static void helperII(int[] arr, int sum, List<List<Integer>> list,List<Integer> temp, int start) {
        if (sum < 0) {
            return;
        } else if (sum == 0) {
            list.add(new ArrayList<>(temp));
            return;
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = start; i < arr.length; i++) {
                if(set.contains(arr[i])){
                    continue;
                }
            set.add(arr[i]);
            temp.add(arr[i]);
            helperII(arr, sum - arr[i], list, temp, i + 1);
            temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSumIII(int k, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helperIII(k, target,list,temp,1);
        return list;
    }
    
    private static void helperIII(int k, int target,List<List<Integer>> list,List<Integer> temp, int start) {
        if(target < 0) {
            return;
        } else if (target == 0 && temp.size() == k) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                helperIII(k, target -i, list, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
        
    }
}
