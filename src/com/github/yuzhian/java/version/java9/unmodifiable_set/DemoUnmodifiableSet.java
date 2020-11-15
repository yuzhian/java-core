package com.github.yuzhian.java.version.java9.unmodifiable_set;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 不可修改的集合, 重写了修改方法, 修改将抛出 {@link UnsupportedOperationException} 异常
 *
 * @author yuzhian
 * @see List#of(java.lang.Object) {@link java.util.ImmutableCollections.AbstractImmutableCollection#add(java.lang.Object)}
 * @see Set#of(java.lang.Object) {@link java.util.ImmutableCollections.AbstractImmutableCollection#add(java.lang.Object)}
 * @see Map#of(java.lang.Object, java.lang.Object) {@link java.util.ImmutableCollections.AbstractImmutableMap#put(java.lang.Object, java.lang.Object)}
 */
@SuppressWarnings("all")
public class DemoUnmodifiableSet {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        Set<String> set = Set.of("A", "B", "C");
        Map<String, String> map = Map.of("KA", "VA", "KB", "VB");
        // list.add("D");
        // set.add("D");
        // map.put("KC", "VC");
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }
}
