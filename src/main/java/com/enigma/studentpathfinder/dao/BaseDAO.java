package com.enigma.studentpathfinder.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T, ID> {
    public void save(T t);
    List<T> list();
    Optional<T> getById(ID id);
}
