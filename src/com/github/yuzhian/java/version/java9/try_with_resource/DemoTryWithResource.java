package com.github.yuzhian.java.version.java9.try_with_resource;

class MyAutoCloseable implements AutoCloseable {

    public void handle() {
        System.out.println("do something...");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}

/**
 * try() 无需变量声明
 *
 * @author yuzhian
 */
public class DemoTryWithResource {
    public static void main(String[] args) {
        MyAutoCloseable autoCloseable = new MyAutoCloseable();
        try (autoCloseable) {
            autoCloseable.handle();
        }
    }
}
