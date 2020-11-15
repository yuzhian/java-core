package com.github.yuzhian.java.common.bean;

/**
 * @author yuzhian
 */
public class Person {
    private String name;    // 姓名
    private int age;        // 年龄
    private char sex;       // 性别
    private String area;    // 地区
    private int salary;     // 薪资

    public Person(String name, int age, char sex, String area, int salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.area = area;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", area='" + area + '\'' +
                ", salary=" + salary +
                '}';
    }
}
