package ru.lenkoa.lessons2.lesson1;

public class Human implements Participating{
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean success;

    public Human(String name, int runLimit, int jumpLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.success = true;
    }

    @Override
    public void run(int limit) {
        if(limit <= runLimit) {
            System.out.println("Человек " + name + " успешно пробежал " + limit);
            success = true;
        } else {
            System.out.println("Человек " + name + " не смог пробежать " + limit + ", он сдулся на "
                    + runLimit + " и уходит с дистанции");
            success = false;
        }
    }

    @Override
    public void jump(int limit) {
        if(limit <= jumpLimit) {
            System.out.println("Человек " + name + " успешно подпрыгнул на высоту " + limit);
            success = true;
        } else {
            System.out.println("Человек " + name + " не смог подпрыгнуть на высоту " + limit
                    + ", он сдулся на " + jumpLimit + " и уходит с дистанции");
            success = false;
        }

    }

    public boolean getSuccess(){
        return success;
    }
}
