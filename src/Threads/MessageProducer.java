package Threads;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
public class MessageProducer implements Runnable
{
    private final BlockingQueue<Integer> sharedQueue;

    public MessageProducer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) { // Produce 15 messages
            try {
                System.out.println("Produced : " + i);
                // Put/produce into sharedQueue with a longer sleep (increased chance for consumer to access)
                sharedQueue.put(i);
                Thread.sleep(5); // Sleep for 5 milliseconds
            } catch (InterruptedException ex) {
                ex.printStackTrace(); // Handle interruption gracefully
            }
        }
    }
}
