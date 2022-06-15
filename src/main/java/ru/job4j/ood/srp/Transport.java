package ru.job4j.ood.srp;

public interface Transport {
    Model getModel();

    int getDistance();

    Transport chooseTransport(Transport transport);
}