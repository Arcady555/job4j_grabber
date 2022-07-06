package ru.job4j.ood.lsp.task2;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingUrupinskTest {

    @Ignore
    @Test
    public void WhenTwoCarsAndTwoTrucks() {
        int[][] array = {
                {1, 1, 1, 1},
                {3, 1, 1, 3},
                {3, 3, 3, 3},
                {1, 1, 1, 1}
        };
        Parking parking = new ParkingUrupinsk(array);
        parking.add(new Car(1));
        parking.add(new Car(1));
        parking.add(new Truck(2));
        parking.add(new Truck(3));
        arrayWhatEv = parking.whatEv();
        arrayExpected = {

        }
    }

}