package ru.itis.service.repositories;

public interface StringsRowMapper<T> {
    T mapRow(String line);
}
