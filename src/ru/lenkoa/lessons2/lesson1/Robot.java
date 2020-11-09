package ru.lenkoa.lessons2.lesson1;

public class Robot implements Participating {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private boolean success;

    public Robot(String name, int runLimit, int jumpLimit){
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.success = true;
    }


    @Override
    public void run(int limit) {
        if(limit <= runLimit) {
            System.out.println("Робот " + name + " успешно пробежал " + limit);
            success = true;
        } else {
            System.out.println("Робот " + name + " не смог пробежать " + limit + ", он сломался на "
                    + runLimit + " и ушёл в ремонт");
            success = false;
        }
    }

    @Override
    public void jump(int limit) {
        if(limit <= jumpLimit) {
            System.out.println("Робот " + name + " успешно подпрыгнул на высоту " + limit);
            success = true;
        } else {
            System.out.println("Робот " + name + " не смог подпрыгнуть на высоту " + limit
                    + ", он сломался на " + jumpLimit + " и ушел в ремонт");
            success = false;
        }
    }

    @Override
    public boolean getSuccess() {
        return success;
    }
}
