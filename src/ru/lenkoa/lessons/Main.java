package ru.lenkoa.lessons;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        invertArray();
        fillArray();
        fillArray2();
        changeArray();
        fillDiagonal(4);

    }

    public static void invertArray(){
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray(){
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray2(){
        int[] arr = new int[8];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++){
            arr[i] = arr[i-1] + 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray() {
        int[] w = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int checkArray = 6;
        for (int i = 0; i < w.length; i++) {
            if (w[i] < checkArray) {
                w[i] = w[i] * 2;
            }
        }
        System.out.println(Arrays.toString(w));
    }

    public static void fillDiagonal(int SIZE){
        int[][] arr = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            arr[i][i] = 1;
            arr[i][SIZE - 1 - i] = 1;
        }
    }

    public static void findMinMax(int SIZE){
        int[] arr = new int[SIZE]

    }




}




