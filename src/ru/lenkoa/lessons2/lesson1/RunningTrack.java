package ru.lenkoa.lessons2.lesson1;

public class RunningTrack implements Obstacles {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public void pass(Participating participating) {
        participating.run(length);
    }
}
