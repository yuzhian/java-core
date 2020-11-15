package com.github.yuzhian.java.version.java7.switch_string;

/**
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
