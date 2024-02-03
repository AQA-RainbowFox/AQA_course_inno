package ru.inno.course.task5;

import ru.inno.course.task1.Player;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        Set<Player> shouldBeUnique = new HashSet<>();
        shouldBeUnique.add(new Player(1, "RainbowFox", true));
        shouldBeUnique.add(new Player(1, "RainbowFox", true));
        shouldBeUnique.add(new Player(2, "1user", false));
        shouldBeUnique.add(new Player(3, "2user", true));
        shouldBeUnique.add(new Player(4, "3user", false));
        shouldBeUnique.add(new Player(5, "4user", true));
        shouldBeUnique.add(new Player(6, "5user", false));
        shouldBeUnique.add(new Player(7, "6user", true));
        shouldBeUnique.add(new Player(8, "7user", false));
        shouldBeUnique.add(new Player(9, "8user", true));
        shouldBeUnique.add(new Player(10, "9user", false));


//  После добавления всех игроков, выведем в консоль все объекты HashSet,
//  чтобы убедиться, что есть только одна запись игрока Player(1, "RainbowFox",true)
        for (Player player : shouldBeUnique) {
            System.out.print("Игрок: "+ player.getNickName()+ " id "+ player.getId());
            if(player.isOnline()){
                System.out.println(" в сети");
            } else {
                System.out.println(" не в сети");
            }
        }


    }
}
