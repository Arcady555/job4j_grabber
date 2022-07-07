package ru.job4j.ood.lsp.task2;

public class Car implements Machine {
    private final int size;

    public Car() {
        this.size = ConstantValues.CAR_SIZE;
    }

    @Override
    public int getSize() {
        return size;
    }
}