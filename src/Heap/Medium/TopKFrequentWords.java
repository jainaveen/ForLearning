package Heap.Medium;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},2));
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new
                PriorityQueue<>((a,b) ->{
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey()); // lexicographically order
            }
            return b.getValue() - a.getValue(); // frequency order
        });
        for(Map.Entry entry : map.entrySet()) {
            pq.add(entry);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }
       return list;
    }
}
