package ru.job4j.ood.ocp;

public class Example2 {
    private int count;

    public void doSomeThing() {
        if (count < 100) {
            System.out.println(count);
        }
    }
}

/**
 * В If лучше поставить предикат, будет больше возможностей для расширения
 */
