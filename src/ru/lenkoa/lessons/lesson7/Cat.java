package ru.lenkoa.lessons.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.appetite = appetite;
        this.name = name;
        this.satiety = satiety;
    }

    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        System.out.println("Кот " + name + " питается");
        doEat(plate);
        satiety = appetite == 0;
    }

    private void doEat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            System.out.println("Кот " + name + " доволен");
            appetite = 0;
        } else {
            appetite -= plate.getFood();
            plate.decreaseFood(plate.getFood());
            System.out.println("Кот " + name + " не наелся, он хочет ещё " + appetite + " еды");
        }
    }

    public boolean getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
