package com.java.study;

import java.util.Arrays;
import java.util.Scanner;

public class Retirement {
    public static void main(String agrs[]){
        int year = 0;

        double payment = 0;
        double insteret_rate = 0;
        double balance = 0;


        Scanner in = new Scanner(System.in);
        System.out.println("how much will you contribute every year?");
        payment = in.nextDouble();
        System.out.println("Interest rate in %");
        insteret_rate = in.nextDouble();
        do{
            balance += payment;
            double insteret = insteret_rate * balance / 100;
            balance += insteret;
            year++;
            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);
            System.out.println("Ready to retire (Y/N)");
        }while(in.next().equals("N"));

    }
}
