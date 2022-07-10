package ru.job4j.ood.lsp.task2;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingUrupinskTest {

    @Test
    public void whenPlusTwoCarsAndOneTrucks() {
        ParkingUrupinsk parking1 = new ParkingUrupinsk(2, 1);
        Assert.assertTrue(parking1.add(new Car()));
        Assert.assertTrue(parking1.add(new Car()));
        Assert.assertTrue(parking1.add(new Truck(2)));
        Assert.assertFalse(parking1.add(new Truck(3)));
    }

    @Test
    public void whenPlusTwoTrucks() {
        Parking parking2 = new ParkingUrupinsk(2, 1);
        Assert.assertTrue(parking2.add(new Truck(3)));
        Assert.assertTrue(parking2.add(new Truck(2)));
        Assert.assertFalse(parking2.add(new Car()));
    }

    @Test
    public void whenPlusTwoCars() {
        Parking parking3 = new ParkingUrupinsk(2, 1);
        Assert.assertTrue(parking3.add(new Car()));
        Assert.assertTrue(parking3.add(new Car()));
        Assert.assertFalse(parking3.add(new Car()));
    }

    @Test
    public void whenPlusOneCarsAndOneTrucks() {
        Parking parking4 = new ParkingUrupinsk(2, 1);
        Assert.assertTrue(parking4.add(new Car()));
        Assert.assertTrue(parking4.add(new Truck(3)));
        Assert.assertFalse(parking4.add(new Truck(2)));
    }
}