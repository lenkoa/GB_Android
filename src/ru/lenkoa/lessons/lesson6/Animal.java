package ru.lenkoa.lessons.lesson6;

public abstract class Animal {
    protected String name;
    protected int maxRunDistance;
    protected double maxJumpHeight;
    protected int maxSwimDistance;

    public Animal(String name, int maxRunDistance, double maxJumpHeight, int maxSwimDistance){
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
    }

    public abstract boolean run(int distance);
    public abstract boolean jump(double height);
    public abstract boolean swim(int distance);

    public boolean checkDistance(String actor, String name, String action, int distance, int maxDistance) {
        if (distance <= maxDistance && distance > 0 && maxDistance > 0){
            System.out.println(actor + " " + name + " " + action + " " + distance + " метров");
            return true;
        } else if (distance > maxDistance && maxDistance > 0){
            System.out.println(actor + " " + name + " не " + action + " " + distance + " метров, он сдулся на расстоянии " + maxDistance + " метров");
            return false;
        } else {
            System.out.println(actor + " " + name + " не " + action + " " + distance + " метров, " + actor + " не умеет");
            return false;
        }
    }

    public boolean checkDistance(String actor, String name, String action, double distance, double maxDistance) {
        if (distance <= maxDistance && distance > 0 && maxDistance > 0){
            System.out.println(actor + " " + name + " " + action + " " + distance + " метров");
            return true;
        } else if (distance > maxDistance && maxDistance > 0){
            System.out.println(actor + " " + name + " не " + action + " " + distance + " метров, он сдулся на расстоянии " + maxDistance + " метров");
            return false;
        } else {
            System.out.println(actor + " " + name + " не " + action + " " + distance + " метров, " + actor + " не умеет");
            return false;
        }
    }

}
