package ru.job4j.ood.srp;

public class LandTransport implements Transport {
    @Override
    public Model getModel() {
        return null;
    }

    @Override
    public int getDistance() {
        return 0;
    }

    @Override
    public Transport chooseTransport(Transport transport) {
        return null;
    }
}
