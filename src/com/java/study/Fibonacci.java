package com.java.study;

public class Fibonacci {
    public static void main(String args[]){
            int length = Integer.parseInt(args[0]);
            int first = 1;
            int second = 1;
            int fibonacci = 0;
            int sum = 2;
            if (length == 1){
                System.out.println(1);
                System.out.println("Average is " + 1);
            }
            else if (length == 2){
                System.out.println(1 + " " + 1);
                System.out.println(1);
            }
            else
                System.out.print(1 + " " + 1 + " ");
                for(int i = 0; i < length - 2; i++){
                    fibonacci = first + second;
                    first = second;
                    second = fibonacci;
                    System.out.print(fibonacci + " ");
                    sum += fibonacci;
                }
                System.out.print("\n");
                System.out.print("Average is " + (double)sum/length);

    }
}
