package com.github.yuzhian.java.version.java5.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

interface I<T> {
}

class C1<T> {
}

class C2 implements I<String> {
}

class C3<T> implements I<T> {
}

class C4 {
    <K, V> V foo(K k, V v) {
        return v;
    }
}

/**
 * 泛型类 | 泛型接口 | 泛型方法
 * java 泛型是语法糖, 伪泛型, 用于编译时更严格的类型检查, 编译后会被擦除,运行时字节码中不包含泛型信息, 最终由强制类型转换处理.
 * 可以通过反射绕过编译时的检查
 *
 * @author yuzhian
 */
public class DemoGenerics {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.getClass().getMethod("add", Object.class).invoke(list, "str");
        System.out.println(list);
    }
}
