package ru.job4j.ood.lsp.task2;

import java.lang.reflect.Array;
import java.util.List;

public class ParkingUrupinsk implements Parking {
    private int[] array;
    int carPlaceAmount;
    int truckPlaceAmount;

    public ParkingUrupinsk(int carPlaceAmount, int truckPlaceAmount) {
        this.carPlaceAmount = carPlaceAmount;
        this.truckPlaceAmount = truckPlaceAmount;
        this.array = new int[carPlaceAmount + truckPlaceAmount];
    }

    @Override
    public boolean add(Machine machine) {
        return false;
    }
}
