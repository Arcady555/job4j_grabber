package ru.job4j.ood.lsp.task2;

import java.util.List;

public interface Parking {
    void add(Machine machine);

    List<List<MyPair>> whatEv();
}
