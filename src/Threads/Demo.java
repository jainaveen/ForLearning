package Threads;

import java.util.concurrent.*;

public class Demo {
    private static final int QUEUE_SIZE = 5; // Increased queue size for better chance of concurrent consumption
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //Creating shared object
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(QUEUE_SIZE);

        // Spawn producer/consumer threads
        executor.submit(new MessageProducer(queue));
        executor.submit(new MessageConsumer(queue));

        System.out.println("Processing messages...");

        // Wait for graceful termination
        executor.shutdown(); // do not receive more tasks

        // Wait for all tasks to finish (including producer) before exiting
        executor.awaitTermination(10, TimeUnit.SECONDS); // Wait for 10 seconds at most
    }
}
