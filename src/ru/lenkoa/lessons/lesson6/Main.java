package ru.lenkoa.lessons.lesson6;

public class Main {
    public static void main(String[] args){
        Cat cat1 = new Cat("Борис Николаевич");
        Dog dog1 = new Dog ("Шарик");


        cat1.run(130);
        cat1.jump(2.33);
        cat1.swim(33);
        dog1.run(750);
        dog1.jump(0.25);
        dog1.swim(7);

    }
}
