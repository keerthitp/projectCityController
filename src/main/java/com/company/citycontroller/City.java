package com.company.citycontroller;

import javax.validation.constraints.Min;

public class City {

    private String name;
    private String state;
    @Min(1)
    private double population;
    private boolean isCapital;

    public City(String name, String state, double population, boolean isCapital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isCapital = isCapital;
    }

    public City() {
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getPopulation() {
        return this.population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public boolean isCapital() {
        return this.isCapital;
    }

    public void setCapital(boolean capital) {
        this.isCapital = capital;
    }
}
