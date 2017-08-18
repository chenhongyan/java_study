package com.java.study;

import com.java.study.Employee;

public class EmployeeTest {
    public static void main(String args[]){
        //这里创建两个员工对象
        Employee yaowen = new Employee("yaowen");
        Employee jiaoshan = new Employee("jiaoshan");
        //分别设置两个员工的职位和年龄，以及薪水
        yaowen.setAge(28);
        yaowen.setDesignation("正式员工");
        yaowen.setSalary(10000);
        yaowen.printEmplyee();

        jiaoshan.setAge(25);
        jiaoshan.setDesignation("实习生");
        jiaoshan.setSalary(8000);
        jiaoshan.printEmplyee();

        //说明final变量为编译期常量
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }
}
