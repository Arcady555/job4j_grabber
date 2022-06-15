package ru.job4j.ood.srp;

import java.time.LocalDateTime;

public class Logistic {
    public void doShip(Transport transport, LocalDateTime time) {
        System.out.println(transport.toString() + time.withHour(4));
    }
}
