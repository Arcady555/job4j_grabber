package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T compare(List<T> value, BiPredicate<T, T> biPredicate) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (biPredicate.test(rsl, value.get(i))) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, (a, b) -> comparator.compare(a, b) < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, (a, b) -> comparator.compare(a, b) > 0);
    }
}
