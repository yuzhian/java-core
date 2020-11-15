package com.github.yuzhian.java.version.java10.var;

import com.github.yuzhian.java.common.bean.Person;

/**
 * 类型推断, 只能用来创建局部变量
 *
 * @author yuzhian
 */
@SuppressWarnings("all")
public class DemoVar {
    // var val = "";
    public static void main(String[] args) {
        var str1 = "aa";
        final var str2 = str1;
        str1 += "c";
        var num = 12;
        var person = new Person("Otto", 24, 'M', "Chicago", 8900);
        System.out.println(str1);
        System.out.println(num);
        System.out.println(str2);
        System.out.println(person instanceof Person);
    }
}
