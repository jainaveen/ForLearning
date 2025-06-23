package Heap.Medium;

import java.util.*;

public class MergeKSortedArray {
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}};
        System.out.println(mergeKArrays(arr,4));
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< K;i++) {
            for (int j = 0; j < K; j++) {
                pq.add(arr[i][j]);
            }
        }
        for (int i = 0; i < arr.length * K; i++) {
            list.add(pq.poll());
        }
        return list;
    }
}
