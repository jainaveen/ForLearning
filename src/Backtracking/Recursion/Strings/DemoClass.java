package Backtracking.Recursion.Strings;

public class DemoClass {
    public static void main(String[] args) {
        Permutations per = new Permutations();
        // Approach used by Kunal -
        per.permutations("","abc");
        //Another approach can be used for String and Array
        //I feel this is the effective approach
        per.permutationsStringArray(new int[] {1,2,3});

        PermutationsII perii = new PermutationsII();
        perii.permutationsStringArray(new int[]{1,1,2});
    }
}
