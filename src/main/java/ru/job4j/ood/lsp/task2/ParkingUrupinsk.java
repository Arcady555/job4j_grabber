package ru.job4j.ood.lsp.task2;

public class ParkingUrupinsk implements Parking {
    private final Machine[] array;
    private int carPlaceAmount;
    private int truckPlaceAmount;
    private int counter;

    public ParkingUrupinsk(int carPlaceAmount, int truckPlaceAmount) {
        this.carPlaceAmount = carPlaceAmount;
        this.truckPlaceAmount = truckPlaceAmount;
        this.array = new Machine[carPlaceAmount + truckPlaceAmount];
        this.counter = 0;
    }

    @Override
    public boolean add(Machine machine) {
        boolean rsl = false;
        if (machine.getSize() > ConstantValues.CAR_SIZE && truckPlaceAmount > 0) {
            array[counter] = machine;
            truckPlaceAmount--;
            counter++;
            rsl = true;
        } else if (carPlaceAmount >= machine.getSize()) {
            array[counter] = machine;
            carPlaceAmount -= machine.getSize();
            counter++;
            rsl = true;
        }
        return rsl;
    }
}
