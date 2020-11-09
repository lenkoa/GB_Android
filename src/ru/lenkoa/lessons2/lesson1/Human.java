package ru.lenkoa.lessons2.lesson1;

public class Human implements Participating{
    public boolean success;

    private String name;
    private int runLimit;
    private int jumpLimit;

    public Human(String name, int runLimit, int jumpLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void run(int limit) {
        if(limit <= runLimit) {
            System.out.println("Человек " + name + " успешно пробежал " + limit);
            success = true;
        } else {
            System.out.println("Человек " + name + " не смог пробежать " + limit + " он сдулся на " + runLimit);
            success = false;
        }
    }

    @Override
    public void jump(int limit) {
        if(limit <= jumpLimit) {
            System.out.println("Человек " + name + " успешно подпрыгнул на высоту " + limit);
            success = true;
        } else {
            System.out.println("Человек " + name + " не смог подпрыгнуть на высоту " + limit + " он сдулся на " + jumpLimit);
            success = false;
        }

    }
}
