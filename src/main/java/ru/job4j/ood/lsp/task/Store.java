package ru.job4j.ood.lsp.task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Food> getList();

    public void add(Food food);
}
