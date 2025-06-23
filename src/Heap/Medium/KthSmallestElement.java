package Heap.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        //using normal array
        System.out.println(findKthSmallest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthSmallestUsingMinHeap(new int[]{1,5,6,3,2,7},2));
    }

    public static int findKthSmallest(int[] nums, int k) {
        int[] countTable = new int[21];
        for(int i : nums)
            countTable[i + 10]++;
        for(int i = 0; i <=countTable.length - 1; i++){
            k -=countTable[i];
            if(k <= 0)
                return i - 10;
        }
        return -1;

    }

    public static int findKthSmallestUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
