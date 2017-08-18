package com.java.study;

class FreshJuice {
    enum FreshJuiceSize{SMALL, MEDIUM, LARGE}
    FreshJuiceSize size;
}
public class FreshJuiceTest {
    public static void main(String agrs[]){
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        System.out.println("size:" + juice.size);
    }
}
