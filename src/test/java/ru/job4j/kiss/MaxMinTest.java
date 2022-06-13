package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void whenMaxOfColl() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = List.of(
                100, 2, 10, 67, 22, 12
        );
        int rsl = maxMin.max(list, comparator);
        Assert.assertEquals(100, rsl);
    }

    @Test
    public void whenMinOfColl() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = List.of(
                100, 2, 10, 67, 22, 12
        );
        int rsl = maxMin.min(list, comparator);
        Assert.assertEquals(2, rsl);
    }

    @Test
    public void whenOne() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = List.of(7);
        int rsl = maxMin.min(list, comparator);
        Assert.assertEquals(7, rsl);
    }

    @Test
    public void whenNull() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = List.of();
        Assert.assertNull(maxMin.min(list, comparator));
    }
}