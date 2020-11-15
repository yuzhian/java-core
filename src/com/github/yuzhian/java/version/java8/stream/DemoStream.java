package com.github.yuzhian.java.version.java8.stream;

import com.github.yuzhian.java.common.bean.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.*;

/**
 * 使用流
 * - Intermediate Operations: 中间操作, 接收一个流, 并返回新的流, 操作是延迟执行的. map(mapToInt, flatMap 等), filter, distinct, sorted, peek, skip, parallel, sequential, unordered 等
 * - Terminal Operations: 终点操作, 真正开始执行流操作, 会返回其他类型或者 void, 不返回新的流. forEach, forEachOrdered, toArray, reduce, collect, min, max, count, iterator 等
 * - Short-circuiting: 短路, 即在未访问完全部数组前, 之要达到要求就能够结束并返回结果. anyMatch, allMatch, noneMatch, findFirst, findAny, limit 等
 *
 * @author yuzhian
 * @see DemoStreamCreate#main(String[]) 构造流
 */
public class DemoStream {
    private static Stream<Person> persons() {
        return Stream.of(
                new Person("Otto", 24, 'M', "Chicago", 8900),
                new Person("Otto", 24, 'M', "Chicago", 8900),
                new Person("Jack", 27, 'M', "Houston", 7000),
                new Person("Lynn", 25, 'F', "Chicago", 7800),
                new Person("Lily", 22, 'F', "Houston", 7800),
                new Person("Owen", 30, 'M', "Chicago", 9500),
                new Person("Anni", 28, 'F', "Chicago", 8200)
        );
    }

    public static void main(String[] args) {
        System.out.println("------ 遍历/筛选 - filter(Intermediate) | foreach(Terminal) ------");
        persons().filter(x -> x.getAge() > 24).forEach(System.out::println);

        System.out.println("------ 排序 - sorted(Intermediate) ------");
        persons().sorted(Comparator.comparing(Person::getSalary).reversed()).forEach(System.out::println);
        System.out.println();
        persons().sorted((p1, p2) ->
                p1.getSalary() == p2.getSalary() ? p2.getAge() - p1.getAge() : p2.getSalary() - p1.getSalary())
                .forEach(System.out::println);

        System.out.println("------ 提取 - skip(Intermediate) | limit(Short-circuiting) ------");
        persons().skip(3).forEach(System.out::println);
        persons().limit(3).forEach(System.out::println);

        System.out.println("------ 合并/去重 - concat | distinct(Intermediate) ------");
        Stream.concat(Stream.of("a", "b"), Stream.of("b", "c", "d")).distinct().limit(3).forEach(System.out::println);
        persons().map(Person::toString).distinct().forEach(System.out::println);

        System.out.println("------ 查找 - findFirst/findAny(Short-circuiting) ------");
        System.out.println(persons().findFirst().orElseThrow());
        System.out.println(persons().findAny().orElseThrow());

        System.out.println("------ 匹配 allMatch/anyMatch/noneMatch(Short-circuiting) ------ ");
        System.out.println(persons().allMatch(x -> x.getAge() > 24));
        System.out.println(persons().anyMatch(x -> x.getAge() > 24));
        System.out.println(persons().noneMatch(x -> x.getAge() > 24));

        System.out.println("------ 聚合 - min/max/count(Terminal) ------");
        System.out.println(persons().min(Comparator.comparing(Person::getAge)).orElseThrow());
        System.out.println(persons().max(Comparator.comparingInt(Person::getSalary)).orElseThrow());
        System.out.println(persons().count());

        System.out.println("------ 映射 - map/mapToInt/...(Intermediate) | flatMap(Intermediate) | peek(Intermediate) ------");
        Stream.of("1", "3", "8", "2").mapToInt(Integer::valueOf).forEach(System.out::println);
        Stream.of("1.1", "2.2", "5.5").mapToDouble(Double::valueOf).forEach(System.out::println);
        Stream.of("abc", "123").map(x -> Arrays.stream(x.split(""))).forEach(System.out::println);      // 接收 Object 对象, 得到嵌套流
        Stream.of("abc", "123").flatMap(x -> Arrays.stream(x.split(""))).forEach(System.out::println);  // 接收 Stream<> 返回值, 得到新的集合流
        persons().map(x -> x.getSalary() * 1.2).forEach(System.out::println);                       // 函数返回结果组成的流
        persons().peek(x -> x.setSalary((int) (x.getSalary() * 1.2))).forEach(System.out::println); // 原元素组成的流

        System.out.println("------ 归约 - reduce(Terminal) ------"); // 按规则缩减为一个值
        System.out.println(persons().map(Person::getSalary).reduce(Integer::sum).orElseThrow());
        System.out.println(persons().map(Person::getSalary).reduce((x, y) -> x > y ? x : y).orElseThrow());
        System.out.println(persons().map(Person::getSalary).reduce((x, y) -> x * 10 + y).orElseThrow());
        System.out.println(IntStream.of(1, 2, 3).max().orElseThrow()); // IntStream / DoubleSteam / LongStream 特有
        System.out.println(IntStream.of(1, 2, 3).min().orElseThrow());
        System.out.println(IntStream.of(1, 2, 3).summaryStatistics());
        System.out.println(DoubleStream.of(1.1, 2.3, 4.2).sum());
        System.out.println(LongStream.of(1, 3, 5).average().orElseThrow());

        System.out.println("------ 归集 - collect(Terminal) | toArray(Terminal) ------");
        System.out.println(Arrays.toString(persons().toArray()));
        System.out.println(persons().collect(Collectors.toList()));
        System.out.println(persons().collect(Collectors.toSet()));
        System.out.println(persons().collect(Collectors.toMap(Person::getName, p -> p, (v1, v2) -> v2)));

        System.out.println("------ 分组/分区 - collect(Terminal) ------");
        System.out.println(persons().collect(Collectors.partitioningBy(x -> x.getSalary() < 10000)));   // 只能且必定有 true/false 两个分区
        System.out.println(persons().collect(Collectors.groupingBy(x -> x.getSalary() < 10000)));       // 仅在需要时创建
        System.out.println(persons().collect(Collectors.groupingBy(Person::getSex)));                   // key 为泛型

        System.out.println("------ 结合 - collect(Terminal) ------");
        System.out.println(persons().map(Person::toString).collect(Collectors.joining(", \n")));

        System.out.println("------ 统计 - collect(Terminal) ------");
        System.out.println(persons().collect(Collectors.summarizingInt(Person::getSalary)));
        System.out.println(persons().collect(Collectors.averagingInt(Person::getSalary)));
    }
}
