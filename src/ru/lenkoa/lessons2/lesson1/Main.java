package ru.lenkoa.lessons2.lesson1;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args){

        ArrayList<Participating> participants = new ArrayList<Participating>();
        participants.add(new Human("Одиссей", 300, 4));
        participants.add(new Human("Лаэрт", 60, 2));
        participants.add(new Cat("Бонифаций", 300, 3));


        ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
        obstacles.add(new Wall(3));
        obstacles.add(new RunningTrack(25));
        obstacles.add(new RunningTrack(400));
        obstacles.add(new Wall(5));
        obstacles.add(new RunningTrack(50));

        for (Participating participant : participants){
            for (int i = 0; i < obstacles.size() && participant.getSuccess(); i++) {
                obstacles.get(i).pass(participant);
            }
        }
    }
}
