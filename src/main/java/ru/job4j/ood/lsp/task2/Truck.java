package ru.job4j.ood.lsp.task2;

public class Truck implements Machine {
    private final int size;

    public Truck(int size) {
        if (size <= ConstantValues.CAR_SIZE) {
            throw new IllegalArgumentException("The Truck's size more then 1!");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}