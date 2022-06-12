package ru.job4j.kiss;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Comparator;
import java.util.List;

public class MaxMinTest extends TestCase {

    public void testMaxOfColl() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = List.of(
                1, 2, 10, 67, 22, 12
        );
        int rsl = maxMin.maxOfColl(list, comparator);
        Assert.assertEquals(67, rsl);
    }

    public void testMinOfColl() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compare;
        List<Integer> list = List.of(
                1, 2, 10, 67, 22, 12
        );
        int rsl = maxMin.minOfColl(list, comparator);
        Assert.assertEquals(1, rsl);
    }
}