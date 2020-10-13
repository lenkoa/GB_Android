package ru.lenkoa.lessons;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        invertArray();
        fillArray();
        fillArray2();
        changeArray();
        fillDiagonal(4);
        findMinMax(new int[] {2, 4, 6, 12, 24, 76, 1});
        System.out.println(checkBalance(new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }));
        System.out.println(checkBalance(new int[] {1, 2, 4, 7}));

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
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    public static void findMinMax(int[] arr){
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++){
            maxElement = Math.max(maxElement, arr[i]);
        }
        int minElement = arr[0];
        for (int i = 1; i < arr.length; i++){
            minElement = Math.min(minElement, arr[i]);
        }
        System.out.println("Минимальный элемент массива: " + minElement);
        System.out.println("Максимальный элемент массива: " + maxElement);
    }

    public static boolean checkBalance (int[] arr){
        int sumOfArray = 0;
        int sumAcc = 0;
        for (int i = 0; i < (arr.length); i++) {
            sumOfArray += arr[i];
        }
        for (int i = 0; i < (arr.length - 1); i++) {
            do {
                sumAcc += arr[i];
            } while (sumAcc <= (sumOfArray-sumAcc));
        }
        return sumAcc == sumOfArray;
    }

    // седьмое не успела пока


}




