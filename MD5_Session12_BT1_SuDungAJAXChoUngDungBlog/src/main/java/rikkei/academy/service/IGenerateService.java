package rikkei.academy.service;

import java.util.Optional;

public interface IGenerateService<T,E> {
    Iterable<T> findAll();

    Optional<T> findById(E e);

    void save(T t);

    void remove(E e);
}
