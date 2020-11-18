package com.github.yuzhian.java.version.java5.loop;

/**
 * 增强循环, 语法糖
 * @author yuzhian
 */
public class DemoEnhancedLoop {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        for (int i : array) {
            System.out.println(i);
        }
    }
}

// 使用 idea 反编译当前类 class 文件后得到的代码
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

// package com.github.yuzhian.java.version.java5.loop;
//
// public class DemoEnhancedLoop {
//     public DemoEnhancedLoop() {
//     }
//
//     public static void main(String[] args) {
//         int[] array = new int[]{1, 2, 3, 4, 5};
//         int[] var2 = array;
//         int var3 = array.length;
//
//         for(int var4 = 0; var4 < var3; ++var4) {
//             int i = var2[var4];
//             System.out.println(i);
//         }
//
//     }
// }
