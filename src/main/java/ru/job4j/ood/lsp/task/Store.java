package ru.job4j.ood.lsp.task;

import java.util.Calendar;
import java.util.List;

public interface Store {
    List<Food> getList();

    boolean accept(Food food);

    boolean add(Food food);

    void removeAllFoods();

    default double expConsumption(Food food) {
        return (double) (Calendar.getInstance().getTimeInMillis()
                - food.getCreateDate().getTimeInMillis())
                / (food.getExpiryDate().getTimeInMillis()
                - food.getCreateDate().getTimeInMillis());
    }
}
