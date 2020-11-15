package com.github.yuzhian.java.version.java7.files;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 获取文件的上下文信息
 *
 * @author yuzhian
 */
public class DemoPath {
    private static void print(String tip, Path path) {
        System.out.println("------------ " + tip + " ------------");
        System.out.println("path: " + path);
        System.out.println("count: " + path.getNameCount());
        System.out.println("root: " + path.getRoot());
        System.out.println("parent: " + path.getParent());
        System.out.println("filename: " + path.getFileName());
        System.out.println("sub path: " + (path.getNameCount() > 2 ? path.subpath(0, 2) : "'null'"));
    }

    public static void main(String[] args) {
        // 创建方式
        print("Paths.get()", Paths.get("resource", "text", "hello_world.txt"));
        print("FileSystems.getDefault().getPath()", FileSystems.getDefault().getPath("resource", "text", "hello_world.txt"));
        print("new File().toPath()", new File("resource/text", "hello_world.txt").toPath());
        // 绝对路径
        print("Paths.get().toAbsolutePath()", Paths.get("resource", "text", "hello_world.txt").toAbsolutePath());
    }
}
