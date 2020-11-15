package com.github.yuzhian.java.version.java5.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Animal implements Comparable<Animal> {
    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal another) {
        return this.age - another.age;
    }
}

class Dog extends Animal {
    public Dog(int age) {
        super(age);
    }
}

/**
 * 泛型通配符(Wildcards) 边界(Bounds) C<A>.class != C<B>.class
 * <T extends E> 类型限定
 * <? extends T> 上界通配符(Upper Bounds Wildcards)
 * <? super T> 下界通配符(Lower Bounds Wildcards)
 *
 * @author yuzhian
 */
public class DemoBounds {
    // 类型限定, 类型必须实现Comparable接口
    public static <T extends Comparable<T>> void sort1(List<T> list) {
        Collections.sort(list);
    }

    // 下界通配符, T implement Comparable<T或者T的父类>, => T的父类E实现Comparable<E>
    public static <T extends Comparable<? super T>> void sort2(List<T> list) {
        Collections.sort(list);
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(25));
        animals.add(new Dog(35));
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(5));
        dogs.add(new Dog(18));

        sort1(animals);
        // sort1(dogs); // Dog extends Animal & Animal implements Comparable<Animal> => 参数必须为 List<Animal>
        sort2(animals);
        sort2(dogs);
    }
}
