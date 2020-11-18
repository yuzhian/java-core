package com.github.yuzhian.java.version.java6.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuzhian
 */
public class DemoDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("a");
        deque.offerLast("b");
        deque.offerLast("c");
        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
