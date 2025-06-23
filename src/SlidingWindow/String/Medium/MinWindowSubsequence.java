package SlidingWindow.String.Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinWindowSubsequence {

    public static void main(String[] args) {
        minwindow();
    }

    public static void minwindow(){
        String str = "aiafceccfgdgikfkgkeaheijjccigaahdabhfikadkejfbjjhkecdkkkcjcjddfhac";
        String str2 = "afgkjcjca";

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if(str.indexOf(c) < 0) {
                System.out.println("output " + " ");
                return;
            }
        }
        int left = -1;
        int right = 0;
        int k = 0;
        List<String> list = new ArrayList<>();
        while(right < str.length()){
            if(str.charAt(right) == str2.charAt(k) && left < 0) {
                left = right;
                k++;
            } else if (str.charAt(right) == str2.charAt(k)) {
                k++;
            }

            if(k == str2.length()) {
                list.add(str.substring(left,right+1));
                right = left;
                k = 0;
                left = -1;
            }
            right++;
        }
        System.out.println(list.stream().min(Comparator.comparing(String::length)).get());
    }
}
