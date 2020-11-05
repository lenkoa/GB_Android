package ru.lenkoa.lessons.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        System.out.println("Котик " + name + "питается");

        if (plate.getFood() >= appetite) {
            doEat(plate);
            System.out.println("Кот " + name + " доволен");
            fullness = true;
        }
        else if(plate.getFood() < appetite && plate.getFood() > 0){
            doEatPartially(plate);
            System.out.println("Кот " + name + " не наелся");
            appetite -= plate.getFood();
        }
        else {
            System.out.println("Коту " + name + "нужна еда!");
        }
    }

    private void doEat(Plate plate) { plate.decreaseFood(appetite); }
    private void doEatPartially(Plate plate) { plate.decreaseFood(plate.getFood()); }
}
