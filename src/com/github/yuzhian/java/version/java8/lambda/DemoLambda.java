package com.github.yuzhian.java.version.java8.lambda;

@FunctionalInterface
interface Compute {
    int compute(int a, int b);

    default Compute compose(Compute before) {
        System.out.println("before");
        return before;
    }

    default Compute andThen(Compute after) {
        System.out.println("after");
        return after;
    }
}

class Method {
    public static int summation(int a, int b) {
        return a + b;
    }

    public static int difference(int a, int b) {
        return a > b ? a - b : b - a;
    }
}

class Mathematician {
    public void print(int a, int b, Compute c) {
        System.out.println(c.compute(a, b));
    }
}

/**
 * 函数作为参数传递进方法中, 可以被隐式转换为 lambda 表达式
 *
 * @author yuzhian
 */
public class DemoLambda {
    public static void main(String[] args) {
        Mathematician m = new Mathematician();
        m.print(1, 2, Method::summation);
        m.print(1, 2, Method::difference);
        m.print(1, 2, (a, b) -> a * 10 + b);
    }
}
