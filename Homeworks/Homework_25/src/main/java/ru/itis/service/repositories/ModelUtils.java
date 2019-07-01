package ru.itis.service.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class ModelUtils {
    public static <T> List<T> getFirst(List<T> target, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T element: target) {
            if (predicate.test(element)) {
                result.add(element);
                return result;
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> target, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T element: target) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
