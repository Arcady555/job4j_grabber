package ru.job4j.ood.lsp.task;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ControlQualityTest {
    @Test
    public void whenInOneStore() {
        Food milk = new Milk("Доярушка");
        milk.setCreateDate(new GregorianCalendar(2022, 4, 25));
        milk.setExpiryDate(new GregorianCalendar(2022, 7, 25));
        Food bread = new Bread("Полюшко");
        bread.setCreateDate(new GregorianCalendar(2022, 5, 16));
        bread.setExpiryDate(new GregorianCalendar(2022, 6, 16));
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.whatWithFood(milk);
        controlQuality.whatWithFood(bread);
        Assert.assertEquals(controlQuality.getStoreSetList().get(0).getClass(), Shop.class);
        Assert.assertEquals(milk, controlQuality.getStoreSetList().get(0).getList().get(0));
        Assert.assertEquals(bread, controlQuality.getStoreSetList().get(0).getList().get(1));
    }

    @Test
    public void whenInTwoStore() {
        Food food = new Milk("Доярушка");
        food.setCreateDate(new GregorianCalendar(2022, 2, 25));
        food.setExpiryDate(new GregorianCalendar(2022, 5, 25));
        Food food1 = new Bread("Полюшко");
        food1.setCreateDate(new GregorianCalendar(2022, 5, 16));
        food1.setExpiryDate(new GregorianCalendar(2022, 6, 16));
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.whatWithFood(food);
        controlQuality.whatWithFood(food1);
        Assert.assertEquals(controlQuality.getStoreSetList().get(0).getClass(), Trash.class);
        Assert.assertEquals(controlQuality.getStoreSetList().get(1).getClass(), Shop.class);
        Assert.assertEquals(food, controlQuality.getStoreSetList().get(0).getList().get(0));
        Assert.assertEquals(food1, controlQuality.getStoreSetList().get(1).getList().get(0));
    }
}