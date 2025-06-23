package Threads;

public class MainThreadDiesChildThreadContinues {

    public static void main(String[] args) {

        System.out.println("Main thread started " + Thread.currentThread().getName());

        Thread t1 = new Thread(new ChildTask());
        t1.start();

        Thread t2 = new Thread(new ChildTask(t1));
        t2.start();

        Thread t3 = new Thread(new ChildTask(t2));
        t3.start();

        try {
            t1.join(); // Main thread will stop execution at this point and wait for T1 to complete
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Main thread finished");
    }
}
