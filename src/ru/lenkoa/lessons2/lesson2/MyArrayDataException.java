package ru.lenkoa.lessons2.lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j){
        super("В ячейке [" + i + "],[" + j + "] лежит не числовое значение");
    }

}
