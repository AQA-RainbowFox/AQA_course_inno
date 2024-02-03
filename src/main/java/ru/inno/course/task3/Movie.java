package ru.inno.course.task3;

import java.util.Objects;

public class Movie {
    private final String name;
    private double rating;
    private String genre;
    private final String country;
    private final String released;
    private boolean isOscar = false;

    public Movie(String name, double rating, String genre, String country, String released, boolean isOscar) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.country = country;
        this.released = released;
        this.isOscar = isOscar;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;

    }

    public String getReleased() {
        return released;
    }

    public boolean isOscar() {
        return isOscar;
    }

    public void setOscar(boolean oscar) {
        isOscar = oscar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Double.compare(getRating(), movie.getRating()) == 0 && isOscar() == movie.isOscar() && Objects.equals(getName(), movie.getName()) && Objects.equals(getGenre(), movie.getGenre()) && Objects.equals(getCountry(), movie.getCountry()) && Objects.equals(getReleased(), movie.getReleased());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRating(), getGenre(), getCountry(), getReleased(), isOscar());
    }

    @Override
    public String toString() {
        return
                "Название = " + name +
                ", Рейтинг = " + rating +
                ", Жанр = " + genre +
                ", Страна = " + country +
                ", Год выпуска = " + released  +
                ", Есть ли Оскар = " + isOscar ;
    }
}
