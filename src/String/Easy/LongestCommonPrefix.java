package String.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] list = {"apple", "app", "apricot"};
        System.out.println("Longest common prefix " + commonPrefix(list));
    }

    private static String commonPrefix(String[] list) {
       // Arrays.sort(list);
        String text = list[0];
        for (int i = 1; i < list.length; i++) {
            String compare = list[i];
            for (int j = 0; j < compare.length(); j++) {
                if(text.length() > j  && compare.charAt(j) != text.charAt(j)) {
                    text = text.substring(0,j);
                    break;
                }
            }
        }
        return text;
    }
}
