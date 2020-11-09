package ru.lenkoa.lessons2.lesson1;

public class Wall implements Obstacles {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getLimit() {
        return height;
    }

    @Override
    public void pass(Participating participating) {
        participating.jump(height);
    }


}
