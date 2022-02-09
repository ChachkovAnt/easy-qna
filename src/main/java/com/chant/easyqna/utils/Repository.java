package com.chant.easyqna.utils;

import java.util.List;

public interface Repository<T> {

    void save(T entity);

    T findById(long id);

    List<T> findAll();

    void deleteAll();
}
