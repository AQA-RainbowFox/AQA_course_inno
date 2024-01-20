package ru.inno.course.task2;

public class Flat {
    Room livingRoom;
    Room bedroom;
    Room kitchen;
    Room bathroom;
    Room study;

    public Flat(Room livingRoom, Room bedroom, Room kitchen, Room bathroom, Room study) {
        this.livingRoom = livingRoom;
        this.bedroom = bedroom;
        this.kitchen = kitchen;
        this.bathroom = bathroom;
        this.study = study;
    }

    @Override
    public String toString() {
        return "Квартира:\n" +
                " Гостиная = " + livingRoom +
                ",\n Спальня = " + bedroom +
                ",\n Кухня = " + kitchen +
                ",\n Ванная = " + bathroom +
                ",\n Кабинет = " + study;
    }
}
