package String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/print-words-vertically/submissions/1372472021/
public class PrintWordsVertically {
    public static void main(String[] args) {
        System.out.println(printVertically("TO BE OR NOT TO BE"));
        System.out.println(multiply("2","3"));

        String t1 = "ABDRC";
        String t2 = "ABC";

        System.out.println(t1.indexOf("C"));
    }

    public static List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int maxLen = 0;
        for (String str : arr) {
            maxLen =  Math.max(maxLen, str.length());
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].length() > i){
                    res.append(arr[j].charAt(i));
                } else {
                    res.append(" ");
                }
            }
            list.add(res.toString().stripTrailing());
        }
        return list;
    }

    public static String multiply(String num1, String num2) {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        String res = String.valueOf(a*b);
        return res;
    }
}
