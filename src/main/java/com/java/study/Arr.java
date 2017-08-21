package com.java.study;

import java.util.Arrays;

public class Arr {
    public static void Arr_print(int[] arr){
    /*
    *可以调用Arrays.toString打印数组中的所有元素
    */
        System.out.println(Arrays.toString(arr));
    }
    public static void Arr_copy(int[] arr, int[] arr_copy){

        arr = Arrays.copyOf(arr, arr.length);
    }
    public static void main(String args[]){
        int[] arr = new int[11];
        int[] arr_copy = new int[11];
        for(int i = 0; i <= 10; i++)
            arr[i] = i;
        Arr_print(arr);
        Arr_copy(arr, arr_copy);
    }

}
