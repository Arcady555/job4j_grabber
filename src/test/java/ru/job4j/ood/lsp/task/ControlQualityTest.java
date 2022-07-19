package ru.job4j.ood.lsp.task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    Food milk1 = new Milk("Доярушка");
    Food bread1 = new Bread("Полюшко");
    Food milk2 = new Milk("НеДоярушка");
    Food bread2 = new Bread("НеПолюшко");

    @Before
    public void setDates() {
        Calendar milk1CD = Calendar.getInstance();
        milk1CD.add(Calendar.MONTH, -3);
        milk1CD.add(Calendar.DAY_OF_MONTH, -8);
        milk1.setCreateDate(milk1CD);
        Calendar milk1ED = Calendar.getInstance();
        milk1ED.add(Calendar.MONTH, 1);
        milk1ED.add(Calendar.DAY_OF_MONTH, -8);
        milk1.setExpiryDate(milk1ED);
        milk1.setPrice(120);
        milk1.setDiscount(0.7);

        Calendar bread1CD = Calendar.getInstance();
        bread1CD.add(Calendar.DAY_OF_MONTH, -17);
        bread1.setCreateDate(bread1CD);
        Calendar bread1ED = Calendar.getInstance();
        bread1ED.add(Calendar.DAY_OF_MONTH, 13);
        bread1.setExpiryDate(bread1ED);

        Calendar milk2CD = Calendar.getInstance();
        milk2CD.add(Calendar.MONTH, -4);
        milk2CD.add(Calendar.DAY_OF_MONTH, -8);
        milk2.setCreateDate(milk2CD);
        Calendar milk2ED = Calendar.getInstance();
        milk2ED.add(Calendar.MONTH, -1);
        milk2ED.add(Calendar.DAY_OF_MONTH, -1);
        milk2.setExpiryDate(milk2ED);

        Calendar bread2CD = Calendar.getInstance();
        bread2CD.add(Calendar.DAY_OF_MONTH, -2);
        bread2.setCreateDate(bread2CD);
        Calendar bread2ED = Calendar.getInstance();
        bread2ED.add(Calendar.DAY_OF_MONTH, 20);
        bread2.setExpiryDate(bread2ED);
    }

    @Test
    public void whenInSeveralStore() {
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
        assertThat(shop.getList(), is(List.of(milk1, bread1)));
        assertThat(trash.getList(), is(List.of(milk2)));
        assertThat(warehouse.getList(), is(List.of(bread2)));
        Assert.assertEquals(milk1.getPrice(), 84);
        controlQuality.resort();

        assertThat(shop.getList(), is(List.of(milk1, bread1)));
        assertThat(trash.getList(), is(List.of(milk2)));
        assertThat(warehouse.getList(), is(List.of(bread2)));
        Assert.assertEquals(milk1.getPrice(), 84);
    }
}