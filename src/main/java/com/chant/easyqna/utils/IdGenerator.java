package com.chant.easyqna.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IdGenerator {

    private static IdGenerator instance;
    private long count = 0L;

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public long getId() {
        this.count++;
        return count;
    }

}
