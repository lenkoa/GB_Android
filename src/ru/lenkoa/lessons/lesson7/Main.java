package ru.lenkoa.lessons.lesson7;
// решение на одну итерацию, без повторений

import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Борис Николаевич", 3);
        cats[1] = new Cat("Бонифаций Тайсюшевич", 4);
        cats[2] = new Cat("Бенито Муссолини", 2);
        cats[3] = new Cat("Варвара Богдансдоттир", 3);

        Plate[] plates = new Plate[4];
        plates[0] = new Plate(5, 0);
        plates[1] = new Plate(4, 0);
        plates[2] = new Plate(6, 0);
        plates[3] = new Plate(3, 0);


        for (Plate value : plates) { // заполняем тарелки случайным количеством еды
            value.addFood(random.nextInt(value.getCapacity() + 1));
        }

        for (Plate plate : plates) // выводим информацию о тарелках в консоль
            plate.printInfo();

        for (Cat cat : cats) { // коты едят
            System.out.println("Кот " + cat.getName() + " пошёл по тарелкам");
            for (int j = 0; j < plates.length && !cat.getSatiety(); j++)
                if (plates[j].getFood() == 0) {
                    System.out.println("Подход к тарелке" + (j + 1) + ", в тарелке нет еды, она показывает днище!");
                } else {
                    System.out.println("Подход к тарелке" + (j + 1) + ", в тарелке еды: " + plates[j].getFood());
                    cat.eat(plates[j]);
                }
            if (!cat.getSatiety()) {
                System.out.println("Кот " + cat.getName() + " голодает!");
            }
        }

        for (Plate plate : plates) // выводим информацию о тарелках в консоль после еды
            plate.printInfo();


    }
}

