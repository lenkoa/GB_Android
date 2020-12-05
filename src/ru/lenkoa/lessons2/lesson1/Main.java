package ru.lenkoa.lessons2.lesson1;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args){

        ArrayList<Participating> participants = new ArrayList<>();
        participants.add(new Human("Одиссей", 300, 4));
        participants.add(new Human("Лаэрт", 60, 2));
        participants.add(new Cat("Бонифаций", 300, 3));
        participants.add(new Robot("Data", 2000, 20));
        participants.add(new Robot("r2d2", 150, 1));



        ArrayList<Obstacles> obstacles = new ArrayList<>();
        obstacles.add(new Wall(3));
        obstacles.add(new RunningTrack(25));
        obstacles.add(new RunningTrack(400));
        obstacles.add(new Wall(5));
        obstacles.add(new RunningTrack(50));

        for (Participating someone : participants){
            for (int i = 0; i < obstacles.size() && someone.getSuccess(); i++) {
                obstacles.get(i).pass(someone);
            }
        }
    }
}
