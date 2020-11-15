package com.github.yuzhian.java.version.java11.string;

/**
 * 增强 String 类操作
 *
 * @author yuzhian
 */
@SuppressWarnings("all")
public class DemoString {
    public static void main(String[] args) {
        System.out.println("".isEmpty()); // 1.6, 对照
        System.out.println(" ".isEmpty());
        System.out.println("\u2000 ".isEmpty());
        System.out.println("\u2000 ".isBlank());
        System.out.println("\u2000 hello world! \u2000".trim()); // 对照
        System.out.println("\u2000 hello world! \u2000".strip());
        System.out.println("\u2000 hello world! \u2000".stripTrailing());
        System.out.println("\u2000 hello world! \u2000".stripLeading());
        System.out.println("\u2000 hello world! \u2000".repeat(3));
        System.out.println("\n hello world! \n".lines().count());
    }
}
