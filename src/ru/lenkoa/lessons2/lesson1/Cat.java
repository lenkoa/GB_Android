package ru.lenkoa.lessons2.lesson1;

public class Cat implements Participating {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean success;

    public Cat(String name, int runLimit, int jumpLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.success = true;
    }

    private void activity(int obstacleSize, int limit, String activity){
        if(obstacleSize <= limit) {
            System.out.println("Кот " + name + " смог " + activity + " " + obstacleSize);
            success = true;
        } else {
            System.out.println("Кот " + name + " не смог " + activity + " " + obstacleSize
                    + ", он сказал что у него лапки на " + limit + " и ушёл спать");
            success = false;
        }
    }

    @Override
    public void run(int obstacleSize) {
        activity(obstacleSize, runLimit, "пробежать");
    }

    @Override
    public void jump(int obstacleSize) {
        activity(obstacleSize, jumpLimit, "подпрыгнуть на");
    }

    @Override
    public boolean getSuccess() {
        return success;
    }
}
