package SlidingWindow.String.Easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubStringWithTwoOccurrences {

    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("abba"));
    }

    public static int maximumLengthSubstring(String s) {
        int maxLen=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int left=0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while(map.containsKey(ch) && map.get(ch) >1) {
                char c = s.charAt(left++);
                map.put(c, map.get(c)-1);
            }
            maxLen = Math.max(maxLen,right-left + 1);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        return maxLen;
    }
}
