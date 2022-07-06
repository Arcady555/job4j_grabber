package ru.job4j.ood.lsp.task2;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingUrupinskTest {

    @Ignore
    @Test
    public void whenPlusTwoCarsAndTwoTrucks() {
        /**
         * Изображаю парковку
         * Ячейки 1-для легковых
         * Ячейки 3-для грузовых
         * (У грузовых размер 2 или 3)
         */
        int[][] array = {
                {1, 1, 1},
                {3, 1, 3},
                {3, 3, 3},
                {1, 1, 1}
        };
        Parking parking = new ParkingUrupinsk(array);
        /**
         * На парковку заехало 2 легковушки и 2 грузовика.
         * Встали на родные клетки, раз они есть в наличии
         * Занимают сперва первые строки и ячейки
         */
        parking.add(new Car(1));
        parking.add(new Car(1));
        parking.add(new Truck(2));
        parking.add(new Truck(3));
        /**
         * После чего массив имеет вид:
         * {0, 0, 1},
         * {0, 1, 0},
         * {3, 3, 3},
         * {1, 1, 1}
         *
         * Вызывается метод "Что ещё?"(можно бы загнать на парковку)
         */
        List<List<MyPair>> listWhatEv = parking.whatEv();
        /**
         * Варианты возможного размещения:
         * (Грузовик 2 может встать на две ячейки 1, если они идут подряд горизонтально или вертикально.
         * Грузовик 3 - на три ячейки 1)
         * (На будущее учесть, что грузовик 2 может встать вместо грузовика 3,
         * но не наоборот)
         */
        List<MyPair> listExpected1 = List.of(
                new MyPair(5, new Car(1)),
                new MyPair(3, new Truck(3))
        );
        List<MyPair> listExpected2 = List.of(
                new MyPair(2, new Car(1)),
                new MyPair(4, new Truck(3))
        );
        List<MyPair> listExpected3 = List.of(
                new MyPair(3, new Car(1)),
                new MyPair(3, new Truck(3)),
                new MyPair(1, new Truck(2))
        );
        /**
         * Список этих вариантов и должен выдать метод parking.whatEv()
         */
        List<List<MyPair>> listExpected = List.of(
                listExpected1,
                listExpected2,
                listExpected3
        );
        /**
         * Вот и сравним))
         */
        Assert.assertEquals(listWhatEv, listExpected);
    }
}