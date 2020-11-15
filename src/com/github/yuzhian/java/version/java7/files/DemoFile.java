package com.github.yuzhian.java.version.java7.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * 文件操作
 *
 * @author yuzhian
 */
public class DemoFile {
    private static void traverse() throws IOException {
        System.out.println("------ 目录递归遍历 ------");
        Files.walkFileTree(Paths.get("resource"), new SimpleFileVisitor<>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println(file.getFileName());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void fileOperation() throws IOException {
        System.out.println("------ 文件操作 ------");
        String temp1 = "resource/temp/temp1.txt";
        String temp2 = "resource/temp/temp2.txt";
        String temp3 = "resource/temp/temp3.txt";
        Files.createDirectories(Paths.get("resource/temp"));
        // 创建
        Files.createFile(Paths.get(temp1));
        // 复制
        Files.copy(Paths.get(temp1), Paths.get(temp2), StandardCopyOption.REPLACE_EXISTING);
        // 移动
        Files.move(Paths.get(temp1), Paths.get(temp3), StandardCopyOption.REPLACE_EXISTING);
        // 删除
        Files.delete(Paths.get(temp2));
        Files.deleteIfExists(Paths.get(temp3));
    }

    private static void fileAttributes() throws IOException {
        System.out.println("------ 文件属性 ------");
        Path path = Paths.get("resource/text/languages.txt");
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.size(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.readAttributes(path, "*"));
    }

    private static void readAndWrite() throws IOException {
        System.out.println("------ 文件读写 ------");
        Path path = Paths.get("resource/temp/read_and_write.txt");
        Files.deleteIfExists(path);
        Files.createFile(path);

        // 写文件, Files.newBufferedWriter()
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write("Hello world!\n");
        }

        // 写文件, 二进制, Files.write()
        Files.write(path, "你好, 世界!\n".getBytes(), StandardOpenOption.APPEND);

        // 读文件, Files.newBufferedReader().readLine()
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        for (String line; (line = reader.readLine()) != null; ) {
            System.out.println(line);
        }

        // 读文件, Files.readAllLines()
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line1 : lines) {
            System.out.println(line1);
        }

        // 读文件, 二进制, Files.readAllBytes()
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws IOException {
        traverse();
        fileOperation();
        fileAttributes();
        readAndWrite();
    }
}
