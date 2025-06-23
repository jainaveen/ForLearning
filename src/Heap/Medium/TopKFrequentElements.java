package Heap.Medium;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
            int[] res = topKFrequent(new int[]{1,1,2,2,2,3,3,3,3,3,4},2);
       // int[] res = topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        for(Map.Entry entry : map.entrySet()) {
            pq.add(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
