package Heap.Basics;

public class Demo {

    public static void main(String[] args) throws Exception {
        MinHeapImplementation minHeap = new MinHeapImplementation();

        minHeap.insert(8);
        minHeap.insert(6);
        minHeap.insert(12);
        minHeap.insert(9);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());

        System.out.println("********Max heap implementation******");
        MaxHeapImplementation maxHeap = new MaxHeapImplementation();

        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(5);
        maxHeap.insert(6);


        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = (int) maxHeap.remove();
        }

        System.out.println(max);
    }
}
