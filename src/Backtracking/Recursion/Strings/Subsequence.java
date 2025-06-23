package Backtracking.Recursion.Strings;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=gdifkIwCJyg&t=38s
public class Subsequence {
    public static void main(String[] args) {
        subsequence("","abc");
        System.out.println();
        System.out.println("Arraylist Subsequence " + subsequenceArr("","abc"));
    }

    static void subsequence(String p,String up ) {
        if(up.isEmpty()) {
            System.out.print(" " + p);
            return;
        }
        char ch = up.charAt(0);
        subsequence(p+ch, up.substring(1));
        subsequence(p, up.substring(1));
    }

    static List<String> subsequenceArr(String p, String up) {
        List<String> list = new ArrayList<>();
        if(up.isEmpty()) {
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        List<String> l1 = subsequenceArr(p+ch, up.substring(1));
        list.addAll(l1);
        List<String> l2 = subsequenceArr(p, up.substring(1));
        list.addAll(l2);
        return list;
    }
}
