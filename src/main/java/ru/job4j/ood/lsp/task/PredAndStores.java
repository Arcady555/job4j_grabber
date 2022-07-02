package ru.job4j.ood.lsp.task;

import java.util.List;
import java.util.function.Predicate;

public class PredAndStores {
    public static final List<Predicate<Food>> PREDICATE_LIST = List.of(
            food -> food.expConsumption() > 0 && food.expConsumption() < 0.25,
            food -> food.expConsumption() > 0.25 && food.expConsumption() < 1,
            food -> food.expConsumption() >= 1
    );

    public static final List<Store> STORE_LIST = List.of(
            new Warehouse(),
            new Shop(),
            new Trash()
    );
}
