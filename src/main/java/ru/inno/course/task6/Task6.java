package ru.inno.course.task6;

import ru.inno.course.task1.Player;

import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        Map<Player, Integer> points = new HashMap<>();
        points.put(new Player(1, "RainbowFox", true), 0);
        points.put(new Player(2, "User2", true), 0);
        points.put(new Player(3, "User3", false), 0);
        points.put(new Player(4, "User4", false), 10);
        points.put(new Player(5, "User5", true), 0);
        points.put(new Player(6, "User6", false), 0);
        points.put(new Player(7, "User7", true), 12);
        points.put(new Player(8, "User8", false), 11);
        points.put(new Player(9, "User9", true), 13);
        points.put(new Player(10, "User10", false), 5);

        List<Map.Entry<Player, Integer>> list = new ArrayList(points.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Player, Integer>>() {
            @Override
            public int compare(Map.Entry<Player, Integer> o1, Map.Entry<Player, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println("Топ 3 игроков:");
        System.out.println(list.get(0).getKey() + " score = " + list.get(0).getValue());
        System.out.println(list.get(1).getKey() + " score = " + list.get(1).getValue());
        System.out.println(list.get(2).getKey() + " score = " + list.get(2).getValue());


    }
}
