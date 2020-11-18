package com.github.yuzhian.java.version.java5.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    int cnt;

    int getCnt() {
        return cnt;
    }

    synchronized void increment() {
        cnt++;
    }
}

/**
 * 原子变量类相关
 *
 * @author yuzhian
 * @see java.util.concurrent.atomic
 */
public class DemoAtomic {
    static int num = 0;
    static Counter counter = new Counter();
    static AtomicInteger cnt = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1_000_000; i++) {
            // 保留一个以计算用时, 全部启用以对比测试.
            executorService.execute(cnt::incrementAndGet);  // 2985 正常
            executorService.execute(() -> num++);           // 2869 小于
            executorService.execute(counter::increment);    // 3157 正常
        }
        long end = System.currentTimeMillis();
        executorService.shutdown();
        Thread.sleep(1000);
        System.out.printf("atomic[%d], synchronized[%d], int[%d], use time[%d]", cnt.get(), counter.getCnt(), num, end - start);
    }
}
