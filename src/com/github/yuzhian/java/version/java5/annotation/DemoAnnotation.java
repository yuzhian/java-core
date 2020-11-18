package com.github.yuzhian.java.version.java5.annotation;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * 元注解
 *
 * @see Retention   保留范围
 * @see Target      注解目标
 * @see Documented  文档
 * @see Inherited   继承
 * @see Repeatable  可重复, 需一个注解容器(1.8)
 */
// @Retention(RetentionPolicy.SOURCE)      // 源码注解, 用于通知编译器信息, 使用后丢弃, 如 {@link Override}, {@link SuppressWarnings}
// @Retention(RetentionPolicy.CLASS)       // 编译时注解, 生成到字节码中, 运行时忽略, Retention 未指定时默认.
@Retention(RetentionPolicy.RUNTIME)     // 运行时注解, 一般用于反射获取, 大多数自定义注解使用(反射必须).
@Target({
        ElementType.TYPE,               // 接口 | 类 | 枚举 | 注解
        ElementType.FIELD,              // 属性字段 | 枚举常量
        ElementType.METHOD,             // 方法
        ElementType.PARAMETER,          // 方法参数
        ElementType.CONSTRUCTOR,        // 构造函数
        ElementType.LOCAL_VARIABLE,     // 局部变量
        ElementType.ANNOTATION_TYPE,    // 注解, 是 TYPE 的子范围
        ElementType.TYPE_PARAMETER,     // 泛型方法 | 泛型类 | 泛型接口(1.8)
        // ElementType.TYPE_USE,           // 任意类型, 将包含以上除了 METHOD 以外所有类型(1.8)
        // ElementType.PACKAGE,            // 包[package-info]
        // ElementType.MODULE,             // 模块[module-info](1.9)
        // ElementType.RECORD_COMPONENT,   // 与记录关联(14, 预览功能, 暂时无法使用)
})
@MyAnnotation({"ANNOTATION_TYPE", "TYPE"})
@interface MyAnnotation {
    String[] value() default "";
}

/**
 * 注解的作用目标, 反射获取注解
 *
 * @author yuzhian
 */
@MyAnnotation("TYPE")
public class DemoAnnotation<@MyAnnotation("TYPE_PARAMETER") T> {
    @MyAnnotation("FIELD")
    private final T memberVariable;

    @MyAnnotation("CONSTRUCTOR")
    public DemoAnnotation(@MyAnnotation("PARAMETER") T memberVariable) {
        this.memberVariable = memberVariable;
    }

    @MyAnnotation("METHOD")
    private static void helloWorld() {
        @MyAnnotation("LOCAL_VARIABLE")
        String localVariable = "world";

        System.out.println(new DemoAnnotation<>("hello").memberVariable + ' ' + localVariable + '!');
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        helloWorld();
        print("接口", MyAnnotation.class.getAnnotation(MyAnnotation.class));
        print("类", DemoAnnotation.class.getAnnotation(MyAnnotation.class));
        print("泛型", null); // 伪泛型, class 中无法存在.
        print("属性", DemoAnnotation.class.getDeclaredField("memberVariable").getAnnotation(MyAnnotation.class));
        print("构造方法", DemoAnnotation.class.getConstructor(Object.class).getAnnotation(MyAnnotation.class));
        print("参数", DemoAnnotation.class.getConstructor(Object.class).getParameters()[0].getAnnotation(MyAnnotation.class));
        print("普通方法", DemoAnnotation.class.getDeclaredMethod("helloWorld").getAnnotation(MyAnnotation.class));
        print("局部变量", null); // 反射无法获取局部变量
    }

    private static void print(String msg, MyAnnotation annotation) {
        System.out.printf("%s\tvalue%s%n", msg, null == annotation ? "[null]" : Arrays.toString(annotation.value()));
    }
}
// 使用 idea 反编译当前类 class 文件后得到的代码
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

// package com.github.yuzhian.java.version.java5.annotation;
//
// import java.io.PrintStream;
// import java.util.Arrays;
//
// @MyAnnotation({"TYPE"})
// public class DemoAnnotation<T> {
//     @MyAnnotation({"FIELD"})
//     private final T memberVariable;
//
//     @MyAnnotation({"CONSTRUCTOR"})
//     public DemoAnnotation(@MyAnnotation({"PARAMETER"}) T memberVariable) {
//         this.memberVariable = memberVariable;
//     }
//
//     @MyAnnotation({"METHOD"})
//     private static void helloWorld() {
//         String localVariable = "world";
//         PrintStream var10000 = System.out;
//         String var10001 = (String)(new DemoAnnotation("hello")).memberVariable;
//         var10000.println(var10001 + " " + localVariable + "!");
//     }
//
//     public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
//         helloWorld();
//         print("接口", (MyAnnotation)MyAnnotation.class.getAnnotation(MyAnnotation.class));
//         print("类", (MyAnnotation)DemoAnnotation.class.getAnnotation(MyAnnotation.class));
//         print("泛型", (MyAnnotation)null);
//         print("属性", (MyAnnotation)DemoAnnotation.class.getDeclaredField("memberVariable").getAnnotation(MyAnnotation.class));
//         print("构造方法", (MyAnnotation)DemoAnnotation.class.getConstructor(Object.class).getAnnotation(MyAnnotation.class));
//         print("参数", (MyAnnotation)DemoAnnotation.class.getConstructor(Object.class).getParameters()[0].getAnnotation(MyAnnotation.class));
//         print("普通方法", (MyAnnotation)DemoAnnotation.class.getDeclaredMethod("helloWorld").getAnnotation(MyAnnotation.class));
//         print("局部变量", (MyAnnotation)null);
//     }
//
//     private static void print(String msg, MyAnnotation annotation) {
//         System.out.printf("%s\tvalue%s%n", msg, null == annotation ? "[null]" : Arrays.toString(annotation.value()));
//     }
// }
