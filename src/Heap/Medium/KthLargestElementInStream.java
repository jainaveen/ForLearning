package Heap.Medium;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    public static void main(String[] args) {
        int k = 4, n = 6;
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(kthLargest(k,arr,n));
    }

    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            minHeap.offer(arr[i]);
            res[i] = minHeap.size() == k ? minHeap.peek() : -1;
            if (minHeap.size() > k) {
                minHeap.poll();
                res[i] = minHeap.peek();
            }
        }

        return res;
    }
}
