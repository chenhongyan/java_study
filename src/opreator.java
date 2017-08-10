import java.util.Collection;
import java.util.Iterator;

public class opreator {
    public static void main(String args[]){
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
            System.out.print(name);
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
}
