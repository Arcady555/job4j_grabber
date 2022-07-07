package ru.job4j.ood.lsp.task2;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingUrupinskTest {

    @Ignore
    @Test
    public void whenPlusTwoCarsAndOneTrucks() {
        Parking parking1 = new ParkingUrupinsk(2, 1);
        Assert.assertTrue(parking1.add(new Car()));
        Assert.assertTrue(parking1.add(new Car()));
        Assert.assertTrue(parking1.add(new Truck(2)));
        Assert.assertFalse(parking1.add(new Truck(3)));
    }

    @Ignore
    @Test
    public void whenTwoTrucks() {
        Parking parking2 = new ParkingUrupinsk(2, 1);
        Assert.assertTrue(parking2.add(new Truck(3)));
        Assert.assertTrue(parking2.add(new Truck(2)));
        Assert.assertFalse(parking2.add(new Car()));
    }
}