package ru.job4j.ood.lsp.task;

import java.util.GregorianCalendar;
import java.util.List;

public interface Store {
    List<Food> getList();

    boolean accept(Food food);

    boolean add(Food food);

    default double expConsumption(Food food) {
        return (double) (new GregorianCalendar(2022, 6, 3).getTimeInMillis()
                - food.getCreateDate().getTimeInMillis())
                / (food.getExpiryDate().getTimeInMillis()
                - food.getCreateDate().getTimeInMillis());
    }
}
