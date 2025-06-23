package Threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunnableCallableEx {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Runnabl
        Runnable run = () -> {
            System.out.println("Runnable " + Thread.currentThread().getName());
        };

        Callable<String> call = () -> {
            Thread.sleep(1000);
            return "Callable " + Thread.currentThread().getName();
        };

        executorService.submit(run);

        Future<String> res = executorService.submit(call);
        try {
            System.out.println("Result from Callable: " + res.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
