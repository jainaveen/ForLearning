package Backtracking.Recursion.Subsequence;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Subsets s = new Subsets();

        System.out.println(s.subsets("abc"));
        System.out.println(s.subsets2(new int[]{1,2,3}));
        System.out.println(s.uniqueSubsets(new int[]{2,1,3}));
    }
}
