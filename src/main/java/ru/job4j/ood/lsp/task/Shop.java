package ru.job4j.ood.lsp.task;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private List<Food> list = new ArrayList<>();

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
        if (expConsumption(food) > ConstantValues.LIMIT_DISCOUNT) {
            if (food.getDiscount() == 0) {
                throw new IllegalArgumentException("Set Discount!");
            }
            discountFood(food);
        }
        return accept(food) && list.add(food);
    }

    private void discountFood(Food food) {
        int newPrice = (int) (food.getPrice() * food.getDiscount());
        food.setPrice(newPrice);
    }
}