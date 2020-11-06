package ru.lenkoa.lessons.lesson7;
// решение на одну итерацию, без повторений
import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static int plateCapacity = 5;

    public static void main(String[] args) {

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Борис Николаевич", 3);
        cats[1] = new Cat("Бонифаций Тайсюшевич", 4);
        cats[2] = new Cat("Бенито Муссолини", 2);
        cats[3] = new Cat("Варвара Богдансдоттир", 3);

        Plate[] plates = new Plate[4];
        plates[0] = new Plate(plateCapacity, 0);
        plates[1] = new Plate(plateCapacity, 0);
        plates[2] = new Plate(plateCapacity, 0);
        plates[3] = new Plate(plateCapacity, 0);


        for (int i = 0; i < plates.length; i++) { // заполняем тарелки случайным количеством еды
            plates[i].addFood(random.nextInt(plateCapacity + 1));
        }

        for (Plate plate: plates // выводим информацию о тарелках в консоль
             )
            plate.printInfo();

        for (Cat cat: cats // кормим котов
             ) {
            for (Plate plate: plates
                 )
                cat.eat(plate);
        }

        for (Plate plate: plates // выводим информацию о тарелках в консоль после еды
        ) {
            plate.printInfo();
        }


    }


}

