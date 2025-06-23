package Backtracking.Recursion.Subsequence;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets {

    public List<List<String>> subsets(String str) {
        List<List<String>> list = new ArrayList<>();
        subsetHelper(new String(),str, list);
        return list;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetHelper2(new ArrayList<>(),nums, list,0);
        return list;
    }

    public List<List<Integer>> uniqueSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        powerSets(nums, result, new ArrayList<>(), 0);
        return result;
    }


    private void powerSets(int[] nums, List<List<Integer>> result, List<Integer> list, int index){

        result.add(new ArrayList<>(list));

        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            powerSets(nums, result, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public void subsetHelper2(List<Integer> l, int[] up, List<List<Integer>> list, int index) {
        if(index == up.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        int ch = up[index];
        l.add(ch);
        subsetHelper2(l, up,list,index+1 );
        l.remove(l.size()-1);
        subsetHelper2(l, up,list ,index+1);
    }

    public void subsetHelper(String pr, String up, List<List<String>> list) {
        if(up.isEmpty()) {
            List<String> l = new ArrayList<>();
            l.add(pr);
            list.add(l);
            return;
        }
        char ch = up.charAt(0);
        subsetHelper(pr+ch, up.substring(1),list );
        subsetHelper(pr, up.substring(1),list );
    }
}
