package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T compare(List<T> value, Comparator<T> comparator, BiPredicate<T, T> biPredicate) {
        T rsl = value.get(0);
        for (int i = 0; i < value.size() - 1; i += 2) {
            T rsl1 = comparator.compare(value.get(i), value.get(i + 1)) > 0 ? value.get(i) : value.get(i + 1);
            if (biPredicate.test(rsl, rsl1)) {
                rsl = rsl1;
            }
        }
        return rsl;
    }

    public <T> T maxOfColl(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator, (a, b) -> comparator.compare(a, b) < 0);
    }

    public <T> T minOfColl(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator, (a, b) -> comparator.compare(a, b) > 0);
    }
}
