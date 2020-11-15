package com.github.yuzhian.java.version.java7.number;

/**
 * 支持 二进制/十六进制 为 byte/sort/int/long 赋值
 * 数字下划线提高可读性
 *
 * @author yuzhian
 */
public class DemoNumber {
    public static void main(String[] args) {
        int int_2 = 0b1011;
        System.out.println(int_2);

        // int int_8 = 083;
        // System.out.println(int_8);

        int int_16 = 0xb;
        System.out.println(int_16);

        System.out.println(0b1_1000_0110_1010_0000);
        System.out.println(100_000);
    }
}
