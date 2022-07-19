package ru.job4j.ood.lsp.task;

import java.util.*;

public class ControlQuality {
    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void whatWithFood(Food food) {
        for (Store store : storeList) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Store store : storeList) {
            foodList.addAll(store.getList());
            store.removeAllFoods();
        }
        for (Food food : foodList) {
            whatWithFood(food);
        }
    }
}