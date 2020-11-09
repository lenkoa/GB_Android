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

    @Override
    public void run(int limit) {
        if(limit <= runLimit) {
            System.out.println("Кот " + name + " успешно пробежал " + limit);
            success = true;
        } else {
            System.out.println("Кот " + name + " не смог пробежать " + limit + ", он сказал, что у него лапки на "
                    + runLimit + " и ушел спать");
            success = false;
        }
    }

    @Override
    public void jump(int limit) {
        if(limit <= jumpLimit) {
            System.out.println("Кот " + name + " успешно подпрыгнул на высоту " + limit);
            success = true;
        } else {
            System.out.println("Кот " + name + " не смог подпрыгнуть на высоту " + limit
                    + ", он сказал, что у него лапки на " + jumpLimit + " и ушел спать");
            success = false;
        }
    }

    @Override
    public boolean getSuccess() {
        return success;
    }
}
