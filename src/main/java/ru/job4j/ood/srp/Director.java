package ru.job4j.ood.srp;

import java.time.LocalDateTime;

public class Director {
    public static void main(String[] args) {
        Transport transport = new AirTransport();
        Logistic logistic = new Logistic();
        LocalDateTime time = LocalDateTime.of(2022, 2, 22, 20, 20, 20);
        logistic.doShip(transport, time);
    }
}
