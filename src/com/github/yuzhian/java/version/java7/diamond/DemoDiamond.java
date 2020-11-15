package com.github.yuzhian.java.version.java7.diamond;

import java.util.*;

/**
 * 钻石操作符, 自动类型推断
 *
 * @author yuzhian
 */
public class DemoDiamond {
    public static void main(String[] args) {
        List<Map<String, List<String>>> before = new ArrayList<Map<String, List<String>>>();
        List<Map<String, List<String>>> now = new ArrayList<>();
        // java7 - java9, 钻石操作符不允许在匿名类上使用, java9 之后钻石操作符实现类共同使用
        List<Map<String, List<String>>> anonymous = new ArrayList<Map<String, List<String>>>() {};
    }
}
