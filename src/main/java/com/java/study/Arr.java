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
    /*
    * 二维数组的循环遍历
     */
    public static void print_arry(){
        int[][] arr = {{1,2,3},{2,3,4}};
        for(int[] row : arr){
            for(int value : row){
                System.out.printf("The value is %d%n", value);
            }
        }
    }
    /*
    * java特有的不等长数组
     */
    public static void LotteryArray(){
        final int NMAX = 10;
        int[][] arr = new int[NMAX+1][];
        for(int i = 0; i <= NMAX; i++)
            arr[i] = new int[i + 1];
        for(int n = 0; n < arr.length; n++){
            for(int m = 0; m < arr[n].length; m++){
                int odds = 1;
                for(int i = 1; i <= m; i++){
                    odds = odds * (n - i + 1) / i;
                }
                arr[n][m] = odds;
            }
        }
        for(int[] row : arr){
            for(int value : row){
                System.out.printf("%4d",value);
            }
            System.out.println();
        }

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
        print_arry();
        LotteryArray();


    }

}
