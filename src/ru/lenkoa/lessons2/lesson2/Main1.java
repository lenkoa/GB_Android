package ru.lenkoa.lessons2.lesson2;

public class Main1 {
    public static final int SIZE = 4;
    public static String[][] array = new String[SIZE][SIZE];

    public static void main (String[] args){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "1";
            }
        }
        array[1][2] = "ква";
        array[2][1] = "мяу";

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
        StringBuilder errorMessage = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    errorMessage.append("ячейка: [" + i + "][" + j + "] " + e.getMessage() + "\n");
                }
            }
        }

        if (errorMessage.length() == 0) {
            System.out.println("Сумма всех элементов массива равна " + sum);
        } else {
            System.out.println("Сумма всех числовых элементов массива равна " + sum);
            throw new MyArrayDataException("Нечисловые элементы массива: \n" + errorMessage);
        }
    }

}
