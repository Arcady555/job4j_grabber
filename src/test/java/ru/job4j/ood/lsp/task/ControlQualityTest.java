package ru.job4j.ood.lsp.task;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenInSeveralStore() {
        Food milk1 = new Milk("Доярушка");
        milk1.setCreateDate(new GregorianCalendar(2022, 5, 25));
        milk1.setExpiryDate(new GregorianCalendar(2022, 9, 25));
        Food bread1 = new Bread("Полюшко");
        bread1.setCreateDate(new GregorianCalendar(2022, 5, 16));
        bread1.setExpiryDate(new GregorianCalendar(2022, 6, 16));
        Food milk2 = new Milk("НеДоярушка");
        milk2.setCreateDate(new GregorianCalendar(2022, 2, 25));
        milk2.setExpiryDate(new GregorianCalendar(2022, 5, 2));
        Food bread2 = new Bread("НеПолюшко");
        bread2.setCreateDate(new GregorianCalendar(2022, 5, 16));
        bread2.setExpiryDate(new GregorianCalendar(2022, 6, 5));
        bread2.setDiscount(0.75);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> storeList = List.of(
                warehouse,
                shop,
                trash
        );
        ControlQuality controlQuality = new ControlQuality(storeList);
        controlQuality.whatWithFood(milk1);
        controlQuality.whatWithFood(bread1);
        controlQuality.whatWithFood(milk2);
        controlQuality.whatWithFood(bread2);
        Assert.assertEquals(milk1, warehouse.getList().get(0));
        Assert.assertEquals(bread1, shop.getList().get(0));
        Assert.assertEquals(milk2, trash.getList().get(0));
        Assert.assertEquals(bread2, shop.getList().get(1));
    }
}