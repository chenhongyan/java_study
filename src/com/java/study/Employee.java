package com.java.study;//该类是员工的信息类

public class Employee {
    int age;
    public final String name;
    double salary;
    String designation;

    //构造函数
    public Employee(String name) {
        this.name = name;
    }
    //获取年龄
    public void setAge(int age) {
        this.age = age;
    }
    //获取职位名称
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    //获取薪水
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //打印职员信息
    public void printEmplyee()
    {
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Designation:" + designation);
        System.out.println("Salary:" + salary);
    }
}
