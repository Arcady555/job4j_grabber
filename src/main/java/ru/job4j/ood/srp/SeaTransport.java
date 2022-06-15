package ru.job4j.ood.srp;

public class SeaTransport implements Transport {
    private Model model = new Model("Titanic", Sphere.Sea);

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public int getDistance() {
        return 1000;
    }

    @Override
    public Transport chooseTransport(Transport transport) {
        if (getDistance() < 1000) {
             transport = new LandTransport();
        }
        return transport;
    }
}