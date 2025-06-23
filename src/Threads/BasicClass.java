package Threads;

public class BasicClass {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 is running");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Thread 3 is running");
        });
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();

        } catch (Exception ex) {

        }

    }
}
