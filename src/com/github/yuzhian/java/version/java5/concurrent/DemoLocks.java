package com.github.yuzhian.java.version.java5.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SyncCounter implements Runnable {
    private final Lock l = new ReentrantLock(); // 可重入锁
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            try {
                // synchronized | Lock
                // if (!handleBySync()) break;
                if (!handleByLock()) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized boolean handleBySync() throws InterruptedException {
        if (count > 10) return false;

        Thread.sleep(1000); // 增加判断到更改之间的时间间隔触发
        System.out.println(Thread.currentThread().toString() + ':' + count++);
        return true;
    }

    private boolean handleByLock() throws InterruptedException {
        l.lock();
        if (count > 10) {
            l.unlock();
            return false;
        }

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().toString() + ':' + count++);
        l.unlock();
        return true;
    }
}

/**
 * 显式锁
 *
 * @author yuzhian
 * @see java.util.concurrent.locks
 */
public class DemoLocks {
    public static void main(String[] args) {
        Runnable runnable = new SyncCounter();
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }
}
