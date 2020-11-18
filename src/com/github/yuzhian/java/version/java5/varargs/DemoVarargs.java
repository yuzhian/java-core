package com.github.yuzhian.java.version.java5.varargs;

/**
 * 可变长参数, 语法糖, 编译时转换为数组
 *
 * @author yuzhian
 */
public class DemoVarargs {
    private static void print(String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        print("a", "b", "c");
    }
}
