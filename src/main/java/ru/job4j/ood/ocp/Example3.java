package ru.job4j.ood.ocp;

public class Example3 {
    private Example2 example2;

    public Example3(Example2 example2) {
        this.example2 = example2;
    }
}

/**
 * Класс зависит напрямую от логики другого класса. Изменится Example2 - в
 * Example3 тоже
 */
