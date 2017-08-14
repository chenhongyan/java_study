package com.java.study;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

//定义两个类，子类重写父类的方法
class Animals{
    public void run(){
        System.out.println("Animals can move");
    }
}
class Dog extends Animals{
    public void run(){
        //调用父类重写的方法用super关键字
        super.run();
        System.out.println("Dog can run and walk ");
    }
}
//定义java学习代码
public class java_learn {
    public static void main(String args[]){
        //java的字符串练习
        string_equal();
        //java数组拷贝
        copy_array();
        //java操作符练习
        operator();
        //java循环操作练习
        loop();
        //java的interger和character类
        interger();
        //java的数组操作练习
        myarray();
        //java的日期时间练习
        printDate();
        //java的正则表达式练习
        regex();
        //java方法重载
        int result = Minfunction(10,20);
        double result_d = Minfunction(12.2,8.6);
        System.out.println("The min value is "+result);
        System.out.println("The min value is "+result_d);
        //命令行参数的使用
        System.out.println(args[0]);
        //java允许传递可变长的同类型参数
        PrintMax(new double[]{1.2,3.5,3.6});
        //java文件读写
        FileWrite();
        //java异常处理
        exception();
        //类的方法重写
        Animals A = new Animals();
        Dog D = new Dog();
        A.run();
        D.run();
        int list[] = {12,2,3};
        for(int item : list){
            System.out.print(item+",");
        }

    }
    //java字符串内容相等判断
    public static void string_equal(){
        String first = "gao";
        String second = "gao";
        String third = new String(first);
        String fourth = "ga" + "o";
        //字符串的子串
        System.out.println(first.substring(0,2));
        System.out.println(first == second);
        System.out.println(first.equals(second));
        System.out.println(third == first);
        System.out.println(third.equals(first));
        System.out.println(fourth == first);
        System.out.println(fourth.equals(first));
    }
    //java数组拷贝
    public static void copy_array(){
        int[] copy = {0, 1, 2, 3, 4, 5, 6};
        int[] copy_to = new int[3];
        System.arraycopy(copy,0, copy_to, 0, 3);
        for (int item: copy_to){
            System.out.print(item + ",");
        }
        System.out.print("\n");
    }
    //使用foreach打印数组
    public static void printArray(double[]array){
        for(double item_array : array){
            System.out.println(item_array);
        }
    }
    //打印当前的时间
    public static void printDate(){
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat ft = new
                SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: "+ft.format(date));
        try{
            long start = System.currentTimeMillis();
            System.out.println(new Date());
            Thread.sleep(10*60*5);
            long end = System.currentTimeMillis();
            System.out.println(new Date());
            long diff = end - start;
            System.out.println("The time is " + diff);

        }catch (Exception e){
            System.out.println("Got an exception");
        }


    }
    //java的操作符
    public static void operator(){
        int a, b;
        a = 10;
        b = (a == 10) ? 20 : 30;
        System.out.println("The value of b is "+b);
        b = (a == 1) ? 20 : 30;
        System.out.println("The value of b is "+b);

        //instanceof操作符用来查看接口和对象是否一致
        String name = "Litianci";
        boolean result = name instanceof String;
        System.out.println(result);
    }
    //java的循环操作
    public static void loop(){
        //java的循环和c++一样
        int x = 10;
        while(x <= 20){
            x++;
            System.out.println("The value of x is "+x);
            System.out.println("\n");
        }

        //Java的for循环还可以像下面一样使用
        int [] numbers = {21, 32, 34, 23, 76};
        for (int number : numbers){
            System.out.print(number);
            System.out.print(",");
        }
        System.out.println('\n');
        String [] names = {"gaochen","litianci","liting"};
        for (String name_item : names){
            if(name_item == "litianci"){
                break;
            }
            System.out.print(name_item);
            System.out.print(",");
        }

        //java也可以使用迭代器进行迭代
        Collection StringList = java.util.Arrays.asList(names);
        for(Iterator itr = StringList.iterator(); itr.hasNext(); ){
            //String str = (String)itr.next();
            System.out.println(itr.next());
        }
        //测试switch语句中的default作用，每个case后要加break，不然会顺序输出每个结果
        char grade = 'd';
        switch (grade){
            case 'c':
                System.out.println("Your grade is "+grade);
                break;
            default:
                System.out.println("This is a error");
        }
    }
    //java的装箱内置数据类型
    public static void interger(){
        //java中为了使用面向对象的编程，对内置类型进行了封装，并且添加了很多方法
        //number类使用时将数据进行装箱，valueof返回一个Integer对象，不像new创建一个新的对象。
        Integer score = Integer.valueOf(62);
        score.doubleValue();
        System.out.println("The score of you is " + score);
        if(score.compareTo(60) >= 1){
            System.out.println("you success");
        }

        //java的字符Character类
        Character music = 'c';
        if(Character.isLetter(music)){
            System.out.println("This is a char");
        }
        if(Character.isUpperCase(music)){
            System.out.println("This is a Upper");
        }
        if(Character.isDigit(music))
        {
            System.out.println("This is a digtal");
        }

        //java的字符串string类，但是String创建之后就不允许改变，
        //如果需要改变则要使用String buffer
        String word="sentence";
        int len = word.length();
        System.out.println("This word's length is "+len);
        String sentence = word.concat(" world");
        System.out.println(sentence);
        System.out.printf("Your name is %s","wang ni ma \n");

    }
    //java的数组
    public static void myarray(){
        //java数组用于存放固定大小的同类型数据,可以使用foreach循环，也可以使用传统的c++循环输出
        double[] mylist={1.1, 2.2, 3.3, 4.4};
        double max = mylist[0];
        for(double item : mylist){
            System.out.println(item+" ");
            if(max < item){
                max = item;
            }
        }
        for(int i=0; i < mylist.length; i++){
            System.out.println(mylist[i]);
        }
        printArray(mylist);
        System.out.println("The max of list is " + max);
    }
    //java的正则表达式
    public static void regex(){
        String line = "The cat is your cat";
        String matches = "The cat is your cat cat";
        String pattern = "(\\bcat\\b)";
        Pattern my_pattern = Pattern.compile(pattern);
        Matcher my_matcher = my_pattern.matcher(line);
        int count=0;
        while (my_matcher.find()){
            count++;
            System.out.println("count: "+count);
            System.out.println("Find the value:" + my_matcher.start());
            System.out.println("Find the value:" + my_matcher.end());
        }
        Pattern another_pattern = Pattern.compile(line);
        Matcher another_matcher = another_pattern.matcher(matches);
        System.out.println(another_matcher.lookingAt()+"\n"+another_matcher.matches());

    }
    //java的方法重载
    public static int Minfunction(int a, int b){
        int min = 0;
        if(a > b){
            min = b;
        }
        else
            min = a;
        return min;
    }
    public static double Minfunction(double a, double b){
        double min = 0;
        if(a > b){
            min = b;
        }
        else
            min = a;
        return min;
    }
    //java传递可变长同类型参数
    public static void PrintMax(double...numbers){
        if(numbers.length==0){
            System.out.println("There is no arguments");
        }
        double max_value = numbers[0];
        for(double item : numbers){
            if(item > max_value){
                max_value = item;
            }
        }
        System.out.println("The max value is " + max_value);
    }
    //java文件读写
    public static void FileWrite() {
        try {
            byte bWrite [] = {10,20,30,40,50};
            OutputStream os = new FileOutputStream("test.txt");
            for(int x=0; x < bWrite.length ; x++){
                os.write( bWrite[x] ); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for(int i=0; i< size; i++){
                System.out.print((int)is.read() + "  ");
            }
            System.out.print("\n");
            is.close();
        }catch(IOException e){
            System.out.print("Exception");
        }

    }
    //java异常处理
    public static void exception(){
        int array[] = new int[3];
        try{
            System.out.print("Access the third element"+array[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(" there is an error: out of bounds");
        }

    }

}
