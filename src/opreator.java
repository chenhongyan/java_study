public class opreator {
    public static void main(String args[]){
        int a, b;
        a = 10;
        b = (a == 10) ? 20 : 30;
        System.out.println("The value of b is "+b);
        b = (a == 1) ? 20 : 30;
        System.out.println("The value of b is "+b);
        String name = "Litianci";
        boolean result = name instanceof String;
        System.out.println(result);


    }
}
