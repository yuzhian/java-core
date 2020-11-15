package com.github.yuzhian.java.version.java7.try_with_resource;

class MyAutoCloseableA implements AutoCloseable {
    public void handle() {
        System.out.println("A: do something...");
        throw new RuntimeException("A: Exception in handle");
    }

    @Override
    public void close() {
        System.out.println("A: close");
        throw new RuntimeException("A: Exception in closing");
    }
}

class MyAutoCloseableB implements AutoCloseable {
    public void handle() {
        System.out.println("B: do something...");
        throw new RuntimeException("B: Exception in handle");
    }

    @Override
    public void close() {
        System.out.println("B: close");
        throw new RuntimeException("B: Exception in closing");
    }
}

/**
 * try-with-resource 需要资源类型实现 {@link AutoCloseable}
 * 语法糖, 编译时将资源创建后的操作用try包裹起来, 在结束后执行close()方法, 因此会按顺序从后向前关闭
 *
 * @author yuzhian
 */
public class DemoTryWithResource {
    public static void main(String[] args) {
        try (MyAutoCloseableA autoCloseableA = new MyAutoCloseableA();
             MyAutoCloseableB autoCloseableB = new MyAutoCloseableB()) {
            autoCloseableA.handle();
            autoCloseableB.handle();
        }
    }
}

// 使用 idea 反编译当前类 class 文件后得到的代码
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

// package com.github.yuzhian.java.version.java7.try_with_resource;
//
// public class DemoTryWithResource {
//     public DemoTryWithResource() {
//     }
//
//     public static void main(String[] args) {
//         MyAutoCloseableA autoCloseableA = new MyAutoCloseableA();
//
//         try {
//             MyAutoCloseableB autoCloseableB = new MyAutoCloseableB();
//
//             try {
//                 autoCloseableA.handle();
//                 autoCloseableB.handle();
//             } catch (Throwable var7) {
//                 try {
//                     autoCloseableB.close();
//                 } catch (Throwable var6) {
//                     var7.addSuppressed(var6);
//                 }
//
//                 throw var7;
//             }
//
//             autoCloseableB.close();
//         } catch (Throwable var8) {
//             try {
//                 autoCloseableA.close();
//             } catch (Throwable var5) {
//                 var8.addSuppressed(var5);
//             }
//
//             throw var8;
//         }
//
//         autoCloseableA.close();
//     }
// }
