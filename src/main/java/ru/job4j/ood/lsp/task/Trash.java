package ru.job4j.ood.lsp.task;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public List<Food> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean accept(Food food) {
        if (expConsumption(food) <= ConstantValues.LIMIT_MIN) {
            throw new IllegalArgumentException("Invalid data!");
        }
        return expConsumption(food) >= ConstantValues.LIMIT_MAX;
    }

    @Override
    public boolean add(Food food) {
        if (!accept(food)) {
            return false;
        }
        list.add(food);
        return true;
    }
}