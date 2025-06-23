package Heap.Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println(findKthLargestUsingMinHeap(new int[]{1,2,3,4,5,6},4));
    }



    public static int findKthLargestUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the array
        for (int num : nums) {
            // Add the current number to the heap
            minHeap.add(num);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();

    }
}
