package SlidingWindow.String.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestSubStringDistinctWindow {
    public static void main(String[] args) {
        System.out.println(findSubString("aaab"));
        System.out.println(smallestWindowOfDistinctElements("aaab"));
    }

    public static int findSubString( String str) {
        //identify the unique elements
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        int k = set.size();
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i < str.length();i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.size() == k) {
                while(map.size() == k) {
                    minLen = Math.min(minLen,getMapValues(map));
                    char ch = str.charAt(left); //B2-A1-C1
                    map.put(ch, map.getOrDefault(ch,0)-1); //B1-C1-A1
                    if(map.get(ch) == 0) {
                        map.remove(ch); //A1 - C1
                    }
                    left++; // left 6
                }
            }
        }
        return minLen;
    }
    static int getMapValues(Map map) {
        return map.values().stream().mapToInt(i-> (int) i).sum();
    }



    public static int smallestWindowOfDistinctElements(String str) {
        int left = 0, count = 0;
        int[] ch = new int[256];
        int len = Integer.MAX_VALUE;
        //get the unqiue elements
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()) {
            set.add(c);
        }
        int size = set.size();
        for (int right = 0; right < str.length(); right++) {
            if(ch[str.charAt(right)] == 0) {
                count++;
            }
            ch[str.charAt(right-'a')]++;
            while(count == size) {
                len = Math.min(len,(right -left)+1);
                ch[str.charAt(left)]--;
                if(ch[str.charAt(left)] == 0) {
                    count--;
                }
                left++;
            }

        }
        return len;
    }
}
