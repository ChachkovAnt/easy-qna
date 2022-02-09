package com.chant.easyqna.core.users.models;

import com.chant.easyqna.core.users.vo.UserData;
import lombok.Getter;

import java.util.Date;

@Getter
public class User {

    private Long id;
    private UserData data;
    private final Date created;
    private Date updated;

    public User(UserData userData) {
        this.data = userData;
        this.created = new Date();
        this.updated = new Date();
    }

    public void update() {
        this.updated = new Date();
    }

    public void updateData(UserData userData) {
        this.data = userData;
    }

    public void addId(long id) {
        if (this.id == null) {
            this.id = id;
        }
    }
}
