package Tienda.Tienda.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T,Y> {
    List<T> getAll();

    T save(T item);

    void delete(T item);

    Optional<T> getById(Y id);
}
