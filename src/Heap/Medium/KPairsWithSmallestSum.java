package Heap.Medium;

import java.util.*;

public class KPairsWithSmallestSum {
    public static void main(String[] args) {
       int[] nums1 = {1,1,2};
       int[] nums2 = {1,2,3};
       int k = 2;
        System.out.println(kSmallestPairs(nums1,nums2,k));

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>
                ((a,b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1)));
        for(int i = 0; i < nums1.length; i++) {
            for(int j= 0; j < nums2.length; j++) {
                pq.add(Arrays.asList(nums1[i],nums2[j]));
                if(pq.size() > k) { // the priority queue size will never have more than k elements
                    pq.poll();
                }
            }
        }
        return new ArrayList<>(pq);
    }
}

