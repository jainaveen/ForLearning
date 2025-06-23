package Backtracking.Recursion.Medium;

import java.util.*;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
         helper(s, "",0,list);

        return list;
    }

    public static void helper(String str, String str2, int index, List<String> list) {
        if(index == str.length()) {
            list.add(str2);
            return;
        }
        char c = str.charAt(index);
        helper(str, str2 + c, index + 1, list);
        if(Character.isAlphabetic(c)) {
            c = Character.isLowerCase(c)  ? Character.toUpperCase(c) : Character.toLowerCase(c);
            helper(str, str2+c, index + 1, list);
        }
    }


}
