package Backtracking.Recursion.Medium;

import java.util.ArrayList;

public class PermutationSpaces {
    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }

    static ArrayList<String> permutation(String s) {
        ArrayList<String> list = new ArrayList<>();
        helper(s, list,0, "");
        return list;
    }

    static void helper(String str, ArrayList<String> list, int index,String s) {
        if(index == str.length()-1) {
            list.add(s+str.charAt(str.length()-1));
            return;
        }
        helper(str,list,index+1,s+str.charAt(index)+"_");
        helper(str,list,index+1,s+str.charAt(index));
    }
}
