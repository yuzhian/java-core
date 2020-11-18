package com.github.yuzhian.java.version.java5.static_import;

import static com.github.yuzhian.java.version.java5.static_import.C.MAX_INTEGER;

class C {
    public static final String STRING_VAL = "hello world!";
    public static final int MAX_INTEGER = 2147483647;
}

/**
 * 静态导入
 *
 * @author yuzhian
 */
public class DemoStaticImport {
    public static void main(String[] args) {
        System.out.println(C.STRING_VAL);
        System.out.println(MAX_INTEGER);
    }
}
