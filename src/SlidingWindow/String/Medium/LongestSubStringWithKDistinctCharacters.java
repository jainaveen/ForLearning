package SlidingWindow.String.Medium;

import java.util.*;

public class LongestSubStringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "abc";
        int k = 0;
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int left =0;
        int right =0;

        while(right < s.length()) {

            char ch = s.charAt(right);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch,1);
            }

            while(map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left)) ==0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;

        }
        System.out.println("length of k distinct " + maxLen);
    }
}
