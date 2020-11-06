package ru.lenkoa.lessons.lesson6;

public class Cat extends Animal {

    public Cat(String name){
        super(name, 200, 2, 0);
    }

    protected String actor = "Кот";

    public boolean run (int distance){
        return super.checkDistance(actor, name, "пробежал", distance, maxRunDistance);
    }

    public boolean jump(double distance){
        return super.checkDistance(actor, name, "подпрыгнул на", distance, maxJumpHeight);
    }

    public boolean swim(int distance) {
        return super.checkDistance(actor, name, "проплыл", distance, maxSwimDistance);
    }
}
