package SlidingWindow.String.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input = "pwwkew";
        Set<Character> set = new HashSet<>();

        int left =0;
        int right=0;
        int maxLen = Integer.MIN_VALUE;
        while (right < input.length()) {
            char ch = input.charAt(right);

            while(set.contains(ch)) {
                set.remove(input.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        System.out.println("Length of the longest substring " + maxLen);
    }
}
