import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Date;

public class opreator {
    public static void main(String args[]){
        //java操作符练习
        operator();
        //java循环操作练习
        loop();
        //java的interger和character类
        interger();
        //java的数组操作练习
        myarray();

        printDate();



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
        //测试switch语句中的default作用
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
}
