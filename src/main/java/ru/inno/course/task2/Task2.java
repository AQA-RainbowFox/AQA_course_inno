package ru.inno.course.task2;

public class Task2 {
    public static void main(String[] args) {
        Room livingroom_1 = new Room(14.72,4.6, 2.8, 3.2,2);
        Room bedroom_1 = new Room(9.43,2.3, 2.8, 4.1,1);
        Room kitchen_1 = new Room(23.1,6.6, 2.8, 3.5,3);
        Room bathroom_1 = new Room(4.62,2.1, 2.8, 2.2,0);
        Room study_1 = new Room(21.93,5.1, 2.8, 4.3,2);
        Flat Flat_1 = new Flat(livingroom_1,bedroom_1, kitchen_1,bathroom_1,study_1);
        System.out.println(Flat_1.toString());
    }
}
