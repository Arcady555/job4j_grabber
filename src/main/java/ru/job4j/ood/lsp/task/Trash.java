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
        return expConsumption(food) >= ConstantValues.LIMIT_TRASH;
    }

    @Override
    public boolean add(Food food) {
        return accept(food) && list.add(food);
    }
}