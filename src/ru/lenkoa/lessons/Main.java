package ru.lenkoa.lessons;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        randomGame();
    }

    private static void randomGame() {
        int test = random.nextInt(10);
        System.out.println("Угадайте число");

        for (int i = 1; i < 4; i++) {
            System.out.println("Введите целое число от 0 до 9. У вас три попытки. \nПопытка " + i + ":");
            int a = in.hasNextInt() ? in.nextInt() : 10;
            if (a < 0 || a > 9) {
                System.out.println("Вы ввели не число от 0 до 9");
            } else if (a == test) {
                System.out.println("Поздравляю, вы угадали правильно!");
                break;
            } else if (a < test) {
                System.out.println("Вы ввели слишком маленькое число");
            } else {
                System.out.println("Вы ввели слишком большое число");
            }
        }

        tryAgain();
    }

    private static void tryAgain() {
        System.out.println("Повторить игру ещё раз? 1 – да / 0 – нет");

        switch (in.next()) {
            case "0", "нет" -> System.exit(0);
            case "1", "да" -> randomGame();
        }
    }

}