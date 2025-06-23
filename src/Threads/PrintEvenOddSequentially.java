package Threads;

public class PrintEvenOddSequentially {

    private static int currentNumber = 1;
    private static int MAX_NUMBER = 20;

    private static final Object lock = new Object();


    static class OddThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentNumber > MAX_NUMBER) {
                        lock.notify(); // Notify the waiting thread before exiting
                        break;
                    }
                    if (currentNumber % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                        currentNumber++;
                        lock.notify(); // Notify the other thread
                    }
                    try {
                        lock.wait(); // Wait for the other thread
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }


    static class EvenThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentNumber > MAX_NUMBER) {
                        lock.notify(); // Notify the waiting thread before exiting
                        break;
                    }
                    if (currentNumber % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                        currentNumber++;
                        lock.notify(); // Notify the other thread
                    }
                    try {
                        lock.wait(); // Wait for the other thread
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

    static class printNumber implements Runnable {
        private static int curr =1;
        private static int max =30;

        private static final Object lock2 = new Object();

        private int id;
        printNumber(int id) {
            this.id = id;
        }
        @Override
        public void run() {

            while(true) {
                synchronized (lock2) {
                    if(curr > max) {
                        lock2.notifyAll();
                        break;
                    }
                    while(curr % 3 != id) {
                        try {
                            lock2.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if(curr > max) {
                            lock2.notifyAll();
                            break;
                        }
                    }

                    if(curr > max) {
                        lock2.notifyAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "-" + curr + ",");
                    curr++;

                    lock2.notifyAll();
                }
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new OddThread(), "Odd");
        Thread t2 = new Thread(new EvenThread(),"Even");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Finished");


        //print numbers in sequence using multiple threads


        Thread t4 = new Thread(new printNumber(1), "Thread - 4");

        Thread t5 = new Thread(new printNumber(2),"Thread - 5");

        Thread t6 = new Thread(new printNumber(0),"Thread - 6");

        t4.start();
        t5.start();
        t6.start();

        t4.join();
        t5.join();
        t6.join();
        System.out.println("Main thread completed");
    }
}
