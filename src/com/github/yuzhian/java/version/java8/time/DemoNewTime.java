package com.github.yuzhian.java.version.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 日期时间
 *
 * @author yuzhian
 */
public class DemoNewTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("------ 当前时间 ------");
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());

        System.out.println("------ 指定日期 ------");
        System.out.println(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        System.out.println(LocalDateTime.ofEpochSecond(1609459199, 0, ZoneOffset.ofHours(0)));
        System.out.println(LocalDateTime.parse("2020-12-31T23:59:59"));
        System.out.println(LocalDateTime.parse("2020-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        System.out.println("------ 类型转换 ------");
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));
        System.out.println(Date.from(LocalDateTime.now().atZone(ZoneOffset.ofHours(8)).toInstant()));
        System.out.println(Date.from(LocalDate.now().atStartOfDay(ZoneOffset.ofHours(8)).toInstant()));

        System.out.println("------ 获取时间属性 ------");
        System.out.println(now.getYear());
        System.out.println(now.getMonth().getValue());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfWeek().getValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

        System.out.println("------ 计算 ------");
        System.out.println(now.withYear(2000));
        System.out.println(now.plusYears(10));
        System.out.println(now.minusYears(10));
        System.out.println(now.plus(10, ChronoUnit.YEARS));
        System.out.println(now.minus(10, ChronoUnit.YEARS));

        System.out.println("------ 比较 ------");
        LocalDateTime aDT = LocalDateTime.parse("2000-01-01T00:00:00");
        LocalDateTime bDT = LocalDateTime.parse("2020-12-31T23:59:59");
        System.out.println(aDT.isBefore(bDT));
        System.out.println(aDT.isEqual(bDT));
        System.out.println(aDT.isAfter(bDT));
        System.out.println(Duration.between(aDT, bDT).getSeconds());
    }
}
