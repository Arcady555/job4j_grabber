package ru.job4j.ood.isp.task;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleMenuTest {

    @Test
    public void whenAddThenReturnSame1() {
        Menu menu = new SimpleMenu();
        menu.add(ConstantValues.ROOT, "Сходить в магазин", ConstantValues.STUB_ACTION);
        menu.add(ConstantValues.ROOT, "Покормить собаку", ConstantValues.STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", ConstantValues.STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", ConstantValues.STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", ConstantValues.STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), ConstantValues.STUB_ACTION, "1."
                ),
                menu.select("Сходить в магазин").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), ConstantValues.STUB_ACTION, "1.1."
                ),
                menu.select("Купить продукты").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), ConstantValues.STUB_ACTION, "2."
                ),
                menu.select("Покормить собаку").get()
        );
        MenuPrinter menuPrinter = new HardMenuPrinter();
        menuPrinter.print(menu);
    }

    @Test
    public void whenAddThenReturnSame2() {
        Menu menu = new SimpleMenu();
        menu.add(ConstantValues.ROOT, "Сходить в магазин", ConstantValues.STUB_ACTION);
        menu.add(ConstantValues.ROOT, "Покормить собаку", ConstantValues.STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", ConstantValues.STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", ConstantValues.STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", ConstantValues.STUB_ACTION);
        assertEquals(
                menu.select("Сходить в магазин").get(),
                new Menu.MenuItemInfo(
                        "Сходить в магазин", List.of("Купить продукты"), ConstantValues.STUB_ACTION, "1.")
        );
        assertEquals(
                menu.select("Купить продукты").get(),
                new Menu.MenuItemInfo(
                        "Купить продукты", List.of("Купить хлеб", "Купить молоко"), ConstantValues.STUB_ACTION, "1.1."
                )
        );
        assertEquals(
                menu.select("Покормить собаку").get(),
                new Menu.MenuItemInfo(
                        "Покормить собаку", List.of(), ConstantValues.STUB_ACTION, "2."
                )
        );
    }

    @Test
    public void whenPrint() {
        Menu menu = new SimpleMenu();
        menu.add(ConstantValues.ROOT, "Сходить в магазин", ConstantValues.STUB_ACTION);
        menu.add(ConstantValues.ROOT, "Покормить собаку", ConstantValues.STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", ConstantValues.STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", ConstantValues.STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", ConstantValues.STUB_ACTION);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream prev = System.out;
        PrintStream now = new PrintStream(output);
        System.setOut(now);
        new HardMenuPrinter().print(menu);
        System.setOut(prev);
        String expected = String.join(System.lineSeparator(),
                "1.Сходить в магазин",
                "----1.1.Купить продукты",
                "--------1.1.1.Купить хлеб",
                "--------1.1.2.Купить молоко",
                "2.Покормить собаку"
                + System.lineSeparator()
        );
        assertEquals(expected, output.toString());
    }
}