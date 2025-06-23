package Array.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flow","flower","flight"};
        //below logic will not work when the string is in ascending order
        System.out.println("Longest Common Prefix " + longestCommonPrefix(strs));

        //better go for below logic
        System.out.println("Another solution " + solution(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        return prefix;

    }

    public static String solution(String[] strs) {
        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length-1];
        int index = 0;
        String result = "";
        while(index<firstWord.length() && index<lastWord.length()) {
            if(firstWord.charAt(index) == lastWord.charAt(index)) {
                result = result + firstWord.charAt(index);
            } else {
                break;
            }
            index++;
        }
        return result;
    }

}
