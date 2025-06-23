package SlidingWindow.String.Easy;

import java.util.HashSet;
import java.util.Set;

public class SubStringsOfSizeThreeWithDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    public static int countGoodSubstrings(String s) {
        int left=0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        int right = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(set.contains(ch)) {
                set.clear();
                right = ++left;
            } else {
                set.add(ch);
                right++;
            }
            if(set.size() == 3) {
                result++;
                set.clear();
                right = ++left;
            }
        }
        return result;

    }
}
