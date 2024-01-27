package ru.inno.course.task3;

public class Movie {
    public String name;
    public double rating;
    public String genre;
    public String country;
    public String released;
    public boolean isOscar = false;

    public Movie(String name, double rating, String genre, String country, String released, boolean isOscar) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.country = country;
        this.released = released;
        this.isOscar = isOscar;
    }

    public Movie(String name, double rating, String genre, String country, boolean isOscar) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.country = country;
        this.isOscar = isOscar;
    }
}
