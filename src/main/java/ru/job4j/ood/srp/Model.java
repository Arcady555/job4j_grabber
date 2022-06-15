package ru.job4j.ood.srp;

public class Model {

    private String name;

    private Sphere sphere;

    private int crew;

    private int capacity;

    public Model(String name, Sphere sphere) {
        this.name = name;
        this.sphere = sphere;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void chooseModel() {

    }
}

