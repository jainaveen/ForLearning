package Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageConsumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;
    private final AtomicInteger count = new AtomicInteger(0); // Track consumed messages

    public MessageConsumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) { // Synchronized block for fair access check
                if (Thread.currentThread().getName().equals("pool-1-thread-1")) {
                    try {
                        int message = sharedQueue.take(); // Blocking call, wait for message
                        System.out.println("CONSUMED : " + Thread.currentThread().getName() + " >> " + message);
                        count.incrementAndGet(); // Increment consumed message count
                    } catch (InterruptedException ex) {
                        ex.printStackTrace(); // Handle interruption gracefully
                    }
                } else {
                    try {
                        int message = sharedQueue.take(); // Blocking call, wait for message
                        System.out.println("CONSUMED : " + Thread.currentThread().getName() + " >> " + message);
                        count.incrementAndGet(); // Increment consumed message count
                    } catch (InterruptedException ex) {
                        ex.printStackTrace(); // Handle interruption gracefully
                    }
                }

                // Check if producer finished (consumed 15 messages) and exit if so
                if (count.get() == 1000) {
                    System.out.println("Consumer " + Thread.currentThread().getName() + " exiting...");
                    break;
                }
            }
        }
    }
}
