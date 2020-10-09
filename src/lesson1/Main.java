package lesson1;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate(5, 6, 4, 3));
        System.out.println(task10and20(7, 14));
        isPositiveOrNegative(-33);
        System.out.println(isNegative(7));
        greetings("Елена");
        isLeapYear(2006);
    }

    static void testVars() {
        byte valA = 114;
        short valB = 31450;
        int valC = -100516;
        long valD = 3070432098L;
        float valE = 5.15f;
        double valF = -113.45;
        char valG = '&';
        boolean valI = true;
    }

    public static double calculate(int a, int b, int c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task10and20(int a, int b) {
        return 10 <= (a + b) && (a + b) <= 20;
    }

    public static void isPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void isLeapYear(int year) {

        if ((year % 4) != 0) {
            System.out.println("Год не високосный");
        } else if ((year % 100) == 0) {
            if ((year % 400) == 0) {
                System.out.println("Год високосный");
            } else {
                System.out.println("Год не високосный");
            }
        } else {
            System.out.println("Год високосный");
        }
    }
}




