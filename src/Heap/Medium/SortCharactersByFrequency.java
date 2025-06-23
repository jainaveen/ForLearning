package Heap.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
        System.out.println(anotherApproach("raaeaedere"));
    }
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char ch :s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq =
                new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for (Map.Entry entry : map.entrySet()) {
            pq.add(entry);
        }
        StringBuilder str = new StringBuilder();
        int i =0;
        while(i<map.size()) {
          char ch =  pq.poll().getKey();
          int value  = map.get(ch);
          int j = 0;
          while(j<value) {
              str.append(ch);
              j++;
          }
          i++;
        }

        return str.toString();
    }

    public static String anotherApproach(String s) {
        int n = s.length();
        int[] freq = new int[123];

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i)]++;
        }


        List<Pair> list = new ArrayList<Pair>();
        for(int i = 0; i < 123; i++) {
            if(freq[i] > 0) {
                list.add(new Pair((char) i, freq[i]));
            }
        }

        Collections.sort(list, (a, b) -> b.count - a.count);

        StringBuilder sb = new StringBuilder();
        for(Pair pr : list) {
            int count = pr.count;
            for(int i = 0; i < count; i++) {
                sb.append(pr.ch);
            }
        }

        return sb.toString();
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
