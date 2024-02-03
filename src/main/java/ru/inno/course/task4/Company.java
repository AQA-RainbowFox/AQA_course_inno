package ru.inno.course.task4;

import ru.inno.course.task3.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Company {
    private String name;
    private int yearOfFoundation;
    private ArrayList<String> portfolio;

    public Company(String name, int yearOfFoundation, ArrayList<String> portfolio) {
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        this.portfolio = portfolio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public ArrayList<String> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(ArrayList<String> portfolio) {
        this.portfolio = portfolio;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return getYearOfFoundation() == company.getYearOfFoundation() && Objects.equals(getName(), company.getName()) && Objects.equals(getPortfolio(), company.getPortfolio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getYearOfFoundation(), getPortfolio());
    }

    @Override
    public String toString() {
        return  name + ":" + portfolio;
    }
}
