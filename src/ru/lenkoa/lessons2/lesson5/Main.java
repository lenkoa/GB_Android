package ru.lenkoa.lessons2.lesson5;

import java.util.stream.IntStream;

public class Main {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main (String[] args){
        Main main = new Main();
        // main.countA();
        main.countB();

    }

    public synchronized void countA(){
        float[] arr1 = new float[SIZE];
        IntStream.range(0, arr1.length).forEach(i -> arr1[i] = 1);
        System.out.println("Время создания массива 1: " + System.currentTimeMillis());
        long a = System.currentTimeMillis();
        IntStream.range(0, arr1.length).forEach(i -> arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
        System.out.println("Время обработки массива 1: " + (System.currentTimeMillis() - a));
    }

    public synchronized void countB(){
        float[] arr = new float[SIZE];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = 1);
        System.out.println("Время создания массива 2: " + System.currentTimeMillis());
        long a = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            float[] a1 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            IntStream.range(0, a1.length).forEach(i -> a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
            synchronized(arr) {System.arraycopy(a1, 0, arr, 0, h);}
        });
        Thread t2 = new Thread(() -> {
            float[] a2 = new float[h];
            System.arraycopy(arr, h, a2, 0, h);
            IntStream.range(0, a2.length).forEach(i -> a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
            synchronized(arr) {System.arraycopy(a2, 0, arr, h, h);}
        });

        t1.start();
        t2.start();

        System.out.println("Время обработки массива 2: " + (System.currentTimeMillis() - a));
    }
}
