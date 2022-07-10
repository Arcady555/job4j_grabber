package ru.job4j.ood.lsp.task2;

public class ParkingUrupinsk implements Parking {
    private final Machine[] array;
    private int carPlaceAmount;
    private int truckPlaceAmount;

    public Machine[] getArray() {
        return array;
    }

    public ParkingUrupinsk(int carPlaceAmount, int truckPlaceAmount) {
        this.carPlaceAmount = carPlaceAmount;
        this.truckPlaceAmount = truckPlaceAmount;
        this.array = new Machine[carPlaceAmount + truckPlaceAmount];
    }

    @Override
    public boolean add(Machine machine) {
        boolean rsl = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                if (machine.getSize() > ConstantValues.CAR_SIZE) {
                    if (truckPlaceAmount > 0) {
                        array[i] = machine;
                        truckPlaceAmount--;
                        rsl = true;
                        break;
                    } else {
                        if (carPlaceAmount >= machine.getSize()) {
                            array[i] = machine;
                            carPlaceAmount -= machine.getSize();
                            rsl = true;
                            break;
                        }
                    }
                } else {
                    if (carPlaceAmount > 0) {
                        array[i] = machine;
                        carPlaceAmount--;
                        rsl = true;
                        break;
                    }
                }
            }
        }
        return rsl;
    }
}
