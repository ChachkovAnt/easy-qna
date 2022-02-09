package com.chant.easyqna.storage;

import com.chant.easyqna.utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public abstract class Storage<T> {

    final Map<Long, T> entities = new HashMap<>();
    final IdGenerator gen = IdGenerator.getInstance();

}
