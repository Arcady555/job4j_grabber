package ru.job4j.ood.lsp.task;

import java.util.*;

public class ControlQuality {
    private Store store;
    List<Store> storeSetList = new ArrayList<>();

    public List<Store> getStoreSetList() {
        return storeSetList;
    }

    public void whatWithFood(Food food) {
        validation(food);
        for (int i = 0; i < PredAndStores.PREDICATE_LIST.size(); i++) {
            if (PredAndStores.PREDICATE_LIST.get(i).test(food)) {
                store = PredAndStores.STORE_LIST.get(i);
                if (!storeSetList.contains(store)) {
                    storeSetList.add(store);
                }
                break;
            }
        }
        storeSetList.get(storeSetList.indexOf(store)).add(food);
    }

    private void validation(Food food) {
        if ((food.expConsumption() <= 0)) {
            throw new IllegalArgumentException("Invalid data!");
        } else if (food.expConsumption() >= 0.75 && food.expConsumption() < 1) {
            if (food.getDiscount() == 0) {
                throw new IllegalArgumentException("Set Discount!");
            }
            food.setDiscount(food.getDiscount());
        }
    }
}