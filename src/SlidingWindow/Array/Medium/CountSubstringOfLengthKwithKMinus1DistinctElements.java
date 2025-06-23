package SlidingWindow.Array.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubstringOfLengthKwithKMinus1DistinctElements {

    public static void main(String[] args) {
       // System.out.println(countOfSubstrings("abcc",2));
        System.out.println(countOfSubstrings("abcc",2));
        System.out.println(dummy("aabab",3));
    }

    static int countOfSubstrings(String S, int K) {
        int left = 0;
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i),0)+1);
        }
        if(map.size() == K-1){
            count++;
        }
        for (int i = K; i < S.length(); i++) {
            map.put(S.charAt(left), map.getOrDefault(S.charAt(left),0)-1);
            if(map.get(S.charAt(left)) == 0) {
                map.remove(S.charAt(left));
            }
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i),0)+1);
            if(map.size() == K-1) {
                count++;
            }
            left++;
        }
        return count;
    }

    static int dummy(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            count++;
            if(count == k && map.size() == k-1) {
                res++;
            }
        }
        int left = 0;

        for (int i = k; i < s.length(); i++) {
            count--;
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1);
            if(map.get(s.charAt(left)) == 0) {
                map.remove(s.charAt(left));
            }
            count++;
            if(count == k && map.size() == k-1) {
                res++;
            }
            left++;
        }
        return res;
    }
}
