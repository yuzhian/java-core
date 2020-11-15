package com.github.yuzhian.java.version.java8.optional;

import java.util.Optional;
import java.util.Random;

/**
 * @author yuzhian
 */
public class DemoOptional {
    private static Optional<String> stringOptional() {
        return Optional.of("abc");
    }

    private static Optional<String> emptyOptional() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("------ 构造 ------");
        System.out.println(Optional.empty());
        System.out.println(Optional.of(1));

        System.out.println("------ 判断 ------");
        System.out.println(stringOptional().isPresent());
        System.out.println(stringOptional().isEmpty());
        System.out.println(emptyOptional().isPresent());
        System.out.println(emptyOptional().isEmpty());

        System.out.println("------ 判断, 执行 ------");
        stringOptional().ifPresent(System.out::println);
        emptyOptional().ifPresent(System.out::println);
        stringOptional().ifPresentOrElse(System.out::println, () -> System.out.println("'empty'"));
        emptyOptional().ifPresentOrElse(System.out::println, () -> System.out.println("'empty'"));

        System.out.println("------ 空值替换 ------");
        System.out.println(stringOptional().orElse("'empty'"));
        System.out.println(emptyOptional().orElse("'empty'"));
        System.out.println(stringOptional().orElseGet(() -> String.valueOf(new Random().nextInt(10))));
        System.out.println(emptyOptional().orElseGet(() -> String.valueOf(new Random().nextInt(10))));

        System.out.println("------ 空值抛异常 ------");
        System.out.println(stringOptional().orElseThrow());
        System.out.println(emptyOptional().orElseThrow());
        System.out.println(stringOptional().orElseThrow(NullPointerException::new));
        System.out.println(emptyOptional().orElseThrow(NullPointerException::new));

        System.out.println("------ 过滤 ------");
        System.out.println(stringOptional().filter("abc"::equals).isPresent());
        System.out.println(stringOptional().filter("a"::equals).isPresent());

        System.out.println("------ 值处理 ------");
        stringOptional().map(x -> '(' + x + ')').ifPresentOrElse(System.out::println, () -> System.out.println("'empty'"));
        emptyOptional().map(x -> '(' + x + ')').ifPresentOrElse(System.out::println, () -> System.out.println("'empty'"));

        System.out.println("------ 值处理, 返回值组成新的 Optional ------");
        stringOptional().flatMap(x -> Optional.of('(' + x + ')')).ifPresentOrElse(System.out::println, () -> System.out.println("'empty'"));
        emptyOptional().flatMap(x -> Optional.of('(' + x + ')')).ifPresentOrElse(System.out::println, () -> System.out.println("'empty'"));
    }
}
