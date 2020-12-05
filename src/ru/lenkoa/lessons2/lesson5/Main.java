package ru.lenkoa.lessons2.lesson5;

import java.util.stream.IntStream;

public class Main {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;
    static final int h2 = SIZE - h; // на случай нечетного количества элементов в массиве
    private Integer partsFinished = 0; // для метода countB и синхронизации

    public static void main (String[] args){
        Main main = new Main();
        main.countA();
        main.countB();
    }

    public void countA(){
        float[] arr1 = new float[SIZE];
        IntStream.range(0, arr1.length).forEach(i -> arr1[i] = 1);
        // System.out.println("Время создания массива 1: " + System.currentTimeMillis());
        long a = System.currentTimeMillis();
        IntStream.range(0, arr1.length).forEach(i -> arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
        System.out.println("Время обработки массива 1: " + (System.currentTimeMillis() - a));
    }

    public void countB(){
        float[] arr = new float[SIZE];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = 1);
        // System.out.println("Время создания массива 2: " + System.currentTimeMillis());
        long a = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            float[] a1 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            synchronized(arr) {System.arraycopy(a1, 0, arr, 0, h);}
            // System.out.println("Время обработки 1 части массива: " + (System.currentTimeMillis() - a));
            checkFinish(a);
        });

        Thread t2 = new Thread(() -> {
            float[] a2 = new float[h2];
            System.arraycopy(arr, h, a2, 0, h2);
            for (int i = h; i < SIZE; i++) {
                a2[i - h] = (float) (a2[i - h] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            synchronized(arr) {System.arraycopy(a2, 0, arr, h, h2);}
            // System.out.println("Время обработки 2 части массива: " + (System.currentTimeMillis() - a));
            checkFinish(a);
        });

        t1.start();
        t2.start();
    }

    private void checkFinish(long timer){
        synchronized (partsFinished){
            partsFinished++;
            if (partsFinished >= 2) {
                System.out.println("Время обработки массива 2: " + (System.currentTimeMillis() - timer));
            }
        }
    }
}
