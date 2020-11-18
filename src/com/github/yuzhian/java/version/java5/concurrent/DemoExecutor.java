package com.github.yuzhian.java.version.java5.concurrent;

import java.util.concurrent.*;

/**
 * 线程池创建, 执行, 销毁.
 *
 * @author yuzhian
 * @see java.util.concurrent
 */
public class DemoExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        // void execute(Runnable command);
        singleThreadExecutor.execute(() -> System.out.println("Executor.execute(Runnable)")); // return void

        // Future<?> submit(Runnable task);
        Future<?> runnableFuture = singleThreadExecutor.submit(() -> System.out.println("Executor.submit(Runnable)")); // return Future
        System.out.println("Runnable result: " + runnableFuture.get());

        // <T> Future<T> submit(Callable<T> task);
        Future<?> callableFuture = singleThreadExecutor.submit(() -> {
            System.out.println("Executor.submit(Callable)");
            return "Callable Result";
        });
        System.out.println("Callable result: " + callableFuture.get());

        executorService.shutdownNow();
        singleThreadExecutor.shutdown();
        fixedThreadPool.shutdown();
        scheduledExecutorService.shutdown();
    }
}
