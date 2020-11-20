package ru.lenkoa.lessons2.lesson2;

public class Main {
    public static final int SIZE = 4;
    public static String[][] array = new String[SIZE][SIZE];

    public static void main (String[] args){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "1";
            }
        }
        array[1][2] = "ква";

        try {
            sumArray(array);
        } catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }

    }

    private static void sumArray(String[][] array) throws MyArraySizeException,
            MyArrayDataException {
        if(array.length != SIZE || array[0].length != SIZE){
            throw new MyArraySizeException(SIZE);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма всех элементов массива равна " + sum);
    }
}
