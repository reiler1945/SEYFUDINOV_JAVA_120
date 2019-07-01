package ru.itis.service.repositories;

import java.util.Optional;

public interface ModelToStringsRow <T> {
    String toStringRow(Optional<T> model);
}
