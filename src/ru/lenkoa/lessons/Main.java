package ru.lenkoa.lessons;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int SIZE = 3;
    private static int DOTS_TO_WIN; {
        if (SIZE <= 6) {
            DOTS_TO_WIN = 3;
        } else if (SIZE >= 7 && SIZE <= 10) {
            DOTS_TO_WIN = 4;
        } else DOTS_TO_WIN = 5;
    }

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final String HEADER_FIRST_EMPTY = "♥";
    static final String EMPTY = " ";

    static char[][] map = new char[SIZE][SIZE];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        turnGame();
        tryAgain();

    }



    private static void turnGame() {
        initMap();
        printMap();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapRow();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_EMPTY + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printMapRow() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        int countTurns = 0;
        while (countTurns <= SIZE * SIZE) {
            humanTurn();
            printMap();
            countTurns++;
            checkEnd(countTurns, DOT_HUMAN);

            aiTurn();
            printMap();
            countTurns++;
            checkEnd(countTurns, DOT_AI);
        }
    }

    private static void checkEnd(int countTurns, char symbol) {
        if (countTurns >= DOTS_TO_WIN * 2 && checkWin(symbol)) {
        System.out.println("Победил человек");
        break;
    }
        if (countTurns == SIZE * SIZE) {
            System.out.println("Ничья");
            break;
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод человека! Введите номер строки и столбца!");
        do {
            System.out.print("Строка = ");
            if (scanner.hasNextInt()) {
                rowNumber = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не числовое значение");
                scanner.next();
            }
            System.out.print("Столбец = ");
            if (scanner.hasNextInt()) {
                colNumber = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не числовое значение");
                scanner.next();
            }
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_HUMAN;

        int symbolRowNumber = rowNumber - 1;
    }

    private static boolean isCellValid(int rowNumber, int colNumber, boolean isAI) {

        if (!isAI && ((rowNumber < 1) || (rowNumber > SIZE) || (colNumber < 1) || (colNumber > SIZE))) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        }

        if (map[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            if (!isAI) {
                System.out.println("\nВы выбрали занятую ячейку");
            }
            return false;
        }
        return true;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        return isCellValid(rowNumber, colNumber, false);
    }

    private static boolean checkWin(char symbol, int symbolRowNumber, int symbolColNumber) {
        int countWinCells = 0;
        for (int i = 1; i < DOTS_TO_WIN * 2; i++) { // проверяем значения в строке
            countWinCells = map[symbolRowNumber][symbolColNumber - DOTS_TO_WIN + i] == symbol ? countWinCells + 1 : 0;
            return countWinCells >= DOTS_TO_WIN;
        }
        for (int i = 1; i < DOTS_TO_WIN * 2; i++) { // проверяем значения в столбце
            countWinCells = map[symbolRowNumber - DOTS_TO_WIN + i][symbolColNumber] == symbol ? countWinCells + 1 : 0;
            return countWinCells >= DOTS_TO_WIN;
        }
        for (int i = 1; i < DOTS_TO_WIN * 2; i++) { // проверяем значения по диагонали сверху вниз
            countWinCells = map[symbolRowNumber - DOTS_TO_WIN + i][symbolColNumber - DOTS_TO_WIN + i] == symbol ? countWinCells + 1 : 0;
            return countWinCells >= DOTS_TO_WIN;
        }
        for (int i = 1; i < DOTS_TO_WIN * 2; i++) { // проверяем значения по диагонали снизу вверх
            countWinCells = map[symbolRowNumber + DOTS_TO_WIN - i][symbolColNumber - DOTS_TO_WIN + i] == symbol ? countWinCells + 1 : 0;
            return countWinCells >= DOTS_TO_WIN;
        }
        return false;
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;
        System.out.println("\nХод компьютера!\n");
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber, true));

        map[rowNumber - 1][colNumber - 1] = DOT_AI;

        checkWin(DOT_AI, rowNumber - 1, colNumber - 1);
    }

    private static void tryAgain() {
        System.out.println("Повторить игру ещё раз? 1 – да / 0 – нет");

        switch (scanner.next()) {
            case "0", "нет" -> System.exit(0);
            case "1", "да" -> turnGame();
        }
    }
}
