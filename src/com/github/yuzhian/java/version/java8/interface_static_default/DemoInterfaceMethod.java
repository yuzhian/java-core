package com.github.yuzhian.java.version.java8.interface_static_default;

interface Star {
    // 静态方法
    static String sing() {
        return "鸡你太美（づ￣3￣）づ╭❤～";
    }

    // 默认方法1
    default String jump() {
        return "篮球舞步ヽ(･ω･´ﾒ)";
    }

    // 默认方法2
    default String rap() {
        return "大家好, 我是练习时长两年半的个人练习生...";
    }

    String play(String ball);
}

class Kun implements Star {
    // 无法被覆写
    // @Override
    public static String sing() {
        return "鸡你太美（づ￣3￣）づ╭❤～";
    }

    // 重写默认方法2
    @Override
    public String rap() {
        return "阿巴阿巴阿巴≡(/*＠д@)/";
    }

    @Override
    public String play(String ball) {
        return "胯下运" + ball + "ε=ε=ε=ε=ε=ε=┌(;￣◇￣)┘ ";
    }
}

/**
 * @author yuzhian
 */
public class DemoInterfaceMethod {
    public static void main(String[] args) {
        // 接口静态方法
        System.out.println(Star.sing());

        Star s = new Kun();
        // 默认方法
        System.out.println(s.jump());
        // 被重写的默认方法
        System.out.println(s.rap());
        System.out.println(s.play("篮球"));
    }
}
