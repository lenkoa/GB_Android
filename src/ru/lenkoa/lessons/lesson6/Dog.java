package ru.lenkoa.lessons.lesson6;

public class Dog extends Animal {

    public Dog(String name){
        super(name, 500, 0.5, 10);
    }

    protected String actor = "Пёс";

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
