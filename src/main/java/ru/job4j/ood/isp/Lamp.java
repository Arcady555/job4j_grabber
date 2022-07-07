package ru.job4j.ood.isp;

public interface Lamp {
    void photon();

    void electric();
}

class SourceOfLight implements Lamp {

    @Override
    public void photon() {
    }

    @Override
    public void electric() {
    }
}

class LED implements Lamp {

    @Override
    public void photon() {
    }

    @Override
    public void electric() {
    }
}

class Fire implements Lamp {

    @Override
    public void photon() {
    }

    @Override
    public void electric() {
    }
}
