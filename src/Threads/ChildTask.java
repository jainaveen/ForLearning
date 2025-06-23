package Threads;

public class ChildTask implements Runnable{

    public ChildTask() {};

    public ChildTask(Thread threadToJoin) {
        try {
          //  threadToJoin.join();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            // Simulate a long-running task
            for (int i = 1; i <= 5; i++) {
                System.out.println("Child thread " + Thread.currentThread().getName() + " running: Step " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
            System.out.println("Child thread completed. " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.err.println("Child thread interrupted.");
        }
    }
}
