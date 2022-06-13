package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    private <T> T compare2(List<T> value, BiPredicate<T, T> biPredicate) {
        T rsl;
        if (value.size() == 0) {
            rsl = null;
        } else {
            rsl = value.get(0);
            for (int i = 1; i < value.size(); i++) {
                if (biPredicate.test(rsl, value.get(i))) {
                    rsl = value.get(i);
                }
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare2(value, (a, b) -> comparator.compare(a, b) < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare2(value, (a, b) -> comparator.compare(a, b) > 0);
    }
}
