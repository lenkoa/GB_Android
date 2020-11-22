package ru.lenkoa.lessons2.lesson2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int size){
        super("Размер массива не [" + size + "][" + size + "]");
    }

}
