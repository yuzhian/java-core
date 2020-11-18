package com.github.yuzhian.java.version.java7.switch_string;

/**
 * switch 对 String 的支持是一个语法糖, 依靠 hashcode 转化为 int 然后使用 equals 对比来完成的.
 *
 * @author yuzhian
 */
public class DemoSwitchString {
    private static void find(String key) {
        String val;
        switch (key) {
            case "A":
                val = "A";
                break;
            case "B":
                val = "B";
                break;
            case "C":
                val = "C";
                break;
            case "D":
                val = "D";
                break;
            case "E":
                val = "E";
                break;
            default:
                val = "not found";
        }
        System.out.println(val);
    }

    public static void main(String[] args) {
        find("C");
        find("e");
        find("Z");
    }
}

// 使用 idea 反编译当前类 class 文件后得到的代码
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

// package com.github.yuzhian.java.version.java7.switch_string;
//
// public class DemoSwitchString {
//     public DemoSwitchString() {
//     }
//
//     private static void find(String key) {
//         byte var3 = -1;
//         switch(key.hashCode()) {
//             case 65:
//                 if (key.equals("A")) {
//                     var3 = 0;
//                 }
//                 break;
//             case 66:
//                 if (key.equals("B")) {
//                     var3 = 1;
//                 }
//                 break;
//             case 67:
//                 if (key.equals("C")) {
//                     var3 = 2;
//                 }
//                 break;
//             case 68:
//                 if (key.equals("D")) {
//                     var3 = 3;
//                 }
//                 break;
//             case 69:
//                 if (key.equals("E")) {
//                     var3 = 4;
//                 }
//         }
//
//         String val;
//         switch(var3) {
//             case 0:
//                 val = "A";
//                 break;
//             case 1:
//                 val = "B";
//                 break;
//             case 2:
//                 val = "C";
//                 break;
//             case 3:
//                 val = "D";
//                 break;
//             case 4:
//                 val = "E";
//                 break;
//             default:
//                 val = "not found";
//         }
//
//         System.out.println(val);
//     }
//
//     public static void main(String[] args) {
//         find("C");
//         find("e");
//         find("Z");
//     }
// }
