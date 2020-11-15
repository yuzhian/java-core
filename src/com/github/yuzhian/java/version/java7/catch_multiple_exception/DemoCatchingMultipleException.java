package com.github.yuzhian.java.version.java7.catch_multiple_exception;

import java.io.IOException;
import java.util.Random;

/**
 * 单个 catch 内捕获处理多个异常
 *
 * @author yuzhian
 */
public class DemoCatchingMultipleException {
    public static void main(String[] args) {
        try {
            // java12
            switch (new Random().nextInt(6)) {
                case 0 -> throw new ClassCastException("ClassCastException");
                case 1 -> throw new ClassNotFoundException("ClassNotFoundException");
                case 2 -> throw new IOException("IOException");
                default -> System.out.println("成功执行");
            }
        } catch (ClassCastException | ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
