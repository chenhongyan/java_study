package com.java.study;

import java.util.Arrays;

public class Arr {
    public static void Arr_print(int[] arr){
    /*
    *可以调用Arrays.toString打印数组中的所有元素
    */
        System.out.println(Arrays.toString(arr));
    }
    /*
    *调用Arrays.copyOf可以在原有基础上扩展容量
     */
    public static void Arr_copy(int[] arr, int[] arr_copy){

        arr = Arrays.copyOf(arr, 20);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 调用System.copy实现两个数组对象的浅拷贝，不会新建一个对象，底层为c/c++
     */
    public static int[] Arr_copy(int[] arr){
        int[] copy = new int[arr.length];
        System.arraycopy(arr,0, copy,0, arr.length);
        System.out.println(Arrays.toString(copy));
        return copy;
    }
    public static void main(String args[]){
        int[] arr = new int[11];
        int[] arr_copy = new int[11];
        int[] copy = new int[11];
        for(int i = 0; i <= 10; i++)
            arr[i] = i;
        Arr_print(arr);
        Arr_copy(arr, arr_copy);
        copy = Arr_copy(arr);


    }

}
