package ru.lenkoa.lessons2.lesson1;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args){

        ArrayList<Participating> participants = new ArrayList<Participating>();
        participants.add(new Human("Одиссей", 25, 4));

        ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
        obstacles.add(new Wall(3));



    }
}
