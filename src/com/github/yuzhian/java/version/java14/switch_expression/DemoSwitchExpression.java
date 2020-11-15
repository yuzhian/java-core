package com.github.yuzhian.java.version.java14.switch_expression;

/**
 * 增强 switch 表达式
 *
 * @author yuzhian
 */
public class DemoSwitchExpression {
    public static void main(String[] args) {
        System.out.println(power(1));
        System.out.println(power(4));
    }

    private static int power(int num) {
        return switch (num) {
            case 0 -> 1;
            case 1 -> 2;
            case 2 -> 4;
            case 3 -> 8;
            default -> -1;
        };
    }
}
