package ru.lenkoa.lessons;

public class Main {
    public static void main(String[] args){
        invertArray();

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
    }

    public static void fillArray(){
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i * 3;
        }
    }

    public static void fillArray2(){
        int[] arr = new int[8];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++){
            arr[i] = arr[i-1] + 3;
        }
    }
}




