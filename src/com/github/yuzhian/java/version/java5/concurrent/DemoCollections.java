package com.github.yuzhian.java.version.java5.concurrent;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发容器相关
 *
 * @author yuzhian
 */
public class DemoCollections {
    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(String.valueOf(UUID.randomUUID()), String.valueOf(UUID.randomUUID()));
                map.forEach((k, v) -> System.out.println(k + ':' + v));
                map.clear();
            }, String.valueOf(i)).start();
        }
    }
}
