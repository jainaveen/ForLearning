package Threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync( () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Order id - 123, Nothing phone";
        }, executorService);

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "NaveenKumar";
        }, executorService);

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "UPI payment completed";
        },executorService);

        // Combine all details
        CompletableFuture<String> combine = task1.thenCombine(task2,(order, user) -> order + "\n" + user)
                .thenCombine(task3,(combine1, payment) -> combine1 + "\n" + payment);

        System.out.println(combine.join());

        executorService.shutdown();

    }
}
