package ru.lenkoa.lessons;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int SIZE = 3;
    private static int WIN_CHARS; {
        if (SIZE <= 6) {
            WIN_CHARS = 3;
        } else if (SIZE >= 7 && SIZE <= 10) {
            WIN_CHARS = 4;
        } else WIN_CHARS = 5;
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
        int turnsCount = 0;
        while (turnsCount < SIZE * SIZE) {
            turnsCount++;
            humanTurn();
            printMap();

            turnsCount++;
            aiTurn();
            printMap();
            }
        if (turnsCount == SIZE * SIZE) {
            System.out.println("Ничья");
            tryAgain();
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод человека! Введите номер строки и столбца!");
        do {
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Столбец = ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber)) ;
        map[rowNumber - 1][colNumber - 1] = DOT_HUMAN;

        if (checkWin(DOT_HUMAN, rowNumber - 1, colNumber - 1)) {
            printMap();
            System.out.println("УРА! Вы победили!");
            tryAgain();
        }
    }

    /** /
    private static void repeatTurn() {
        humanTurn(turnsCount);
    }
     /**/

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
        return checkRow(symbol, symbolRowNumber, symbolColNumber) ||
                checkColumn(symbol, symbolRowNumber, symbolColNumber) ||
                checkDoagonal1(symbol, symbolRowNumber, symbolColNumber) ||
                checkDiagonal2(symbol, symbolRowNumber, symbolColNumber);
    }

    private static boolean checkRow(char symbol, int symbolRowNumber, int symbolColNumber) {
        int winCharsCount = 0;
        for (int i = 1; i < WIN_CHARS * 2; i++) { // проверяем значения в строке
            winCharsCount = map[symbolRowNumber][symbolColNumber - WIN_CHARS + i] == symbol ? winCharsCount++ : 0;
        }
        return winCharsCount >= WIN_CHARS;
    }
    private static boolean checkColumn(char symbol, int symbolRowNumber, int symbolColNumber) {
        int winCharsCount = 0;
        for (int i = 1; i < WIN_CHARS * 2; i++) { // проверяем значения в столбце
            winCharsCount = map[symbolRowNumber - WIN_CHARS + i][symbolColNumber] == symbol ? winCharsCount++ : 0;
        }
        return winCharsCount >= WIN_CHARS;
    }

    private static boolean checkDoagonal1(char symbol, int symbolRowNumber, int symbolColNumber) {
        int winCharsCount = 0;
        for (int i = 1; i < WIN_CHARS * 2; i++) { // проверяем значения по диагонали сверху вниз
            winCharsCount = map[symbolRowNumber - WIN_CHARS + i][symbolColNumber - WIN_CHARS + i] == symbol ? winCharsCount + 1 : 0;
        }
        return winCharsCount >= WIN_CHARS;
    }

    private static boolean checkDiagonal2(char symbol, int symbolRowNumber, int symbolColNumber) {
        int winCharsCount = 0;
        for (int i = 1; i < WIN_CHARS * 2; i++) { // проверяем значения по диагонали снизу вверх
            winCharsCount = map[symbolRowNumber + WIN_CHARS - i][symbolColNumber - WIN_CHARS + i] == symbol ? winCharsCount + 1 : 0;
        }
        return winCharsCount >= WIN_CHARS;
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

        if (checkWin(DOT_AI, rowNumber - 1, colNumber - 1)) {
            printMap();
            System.out.println("Победил AI!");
            tryAgain();
        }
    }

    private static void tryAgain() {
        System.out.println("Повторить игру ещё раз? 1 – да / 0 – нет");

        switch (scanner.next()) {
            case "0", "нет" -> System.exit(0);
            case "1", "да" -> turnGame();
        }
    }
}


