package ru.job4j.ood.lsp.task;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> list = new ArrayList<>();
    private int discountFlag;

    @Override
    public List<Food> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean accept(Food food) {
        return expConsumption(food) > ConstantValues.LIMIT_WAREHOUSE
                && expConsumption(food) < ConstantValues.LIMIT_TRASH;
    }

    @Override
    public boolean add(Food food) {
        if (expConsumption(food) > ConstantValues.LIMIT_DISCOUNT && discountFlag == 0) {
            if (food.getDiscount() == 0) {
                throw new IllegalArgumentException("Set Discount!");
            }
            discountFood(food);
            discountFlag++;
        }
        return accept(food) && list.add(food);
    }

    @Override
    public void removeAllFoods() {
        list.clear();
    }

    private void discountFood(Food food) {
        int newPrice = (int) (food.getPrice() * food.getDiscount());
        food.setPrice(newPrice);
    }
}