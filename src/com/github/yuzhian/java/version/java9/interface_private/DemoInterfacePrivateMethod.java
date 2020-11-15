package com.github.yuzhian.java.version.java9.interface_private;

interface I {

    default String echo(String words) {
        return preAppend(words);
    }

    private String preAppend(String str) {
        return "I echo:" + str;
    }
}

class C implements I {
    @Override
    public String echo(String words) {
        return preAppend(words);
    }

    // @Override
    private String preAppend(String str) {
        return "C echo:" + str;
    }
}

/**
 * 接口支持私有方法, 遵循访问修饰符规则, 无法被覆写
 *
 * @author yuzhian
 */
public class DemoInterfacePrivateMethod {
    public static void main(String[] args) {
        System.out.println(new I() {
        }.echo("sdf"));
        System.out.println(new C() {
        }.echo("sdf"));
    }
}
