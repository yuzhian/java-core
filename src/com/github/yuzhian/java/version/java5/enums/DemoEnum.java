package com.github.yuzhian.java.version.java5.enums;

// final class Day extends java.lang.Enum<Day> {
//     public static final Day MONDAY;
//     public static final Day TUESDAY;
//     public static final Day WEDNESDAY;
//     public static final Day THURSDAY;
//     public static final Day FRIDAY;
//     public static final Day SATURDAY;
//     public static final Day SUNDAY;
//     private final java.lang.String ch;
//     private final int value;
//     private static final Day[] $VALUES;
//     public static Day[] values();
//     public static Day valueOf(java.lang.String);
//     private Day(java.lang.String, int);
//     public java.lang.String getCh();
//     public int getValue();
//     static {};
// }

enum Day {
    MONDAY("星期一", 1),
    TUESDAY("星期二", 2),
    WEDNESDAY("星期三", 3),
    THURSDAY("星期四", 4),
    FRIDAY("星期五", 5),
    SATURDAY("星期六", 6),
    SUNDAY("星期日", 7);

    private final String ch;
    private final int value;

    Day(String ch, int value) {
        this.ch = ch;
        this.value = value;
    }

    public String getCh() {
        return ch;
    }

    public int getValue() {
        return value;
    }
}

/**
 * 枚举, 语法糖
 *
 * @author yuzhian
 * @see Enum
 */
public class DemoEnum {
    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }
}
