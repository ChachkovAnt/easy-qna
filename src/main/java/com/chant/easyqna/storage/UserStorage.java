package com.chant.easyqna.storage;

import com.chant.easyqna.core.users.models.User;
import com.chant.easyqna.core.users.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStorage extends Storage<User> implements UserRepository {

    private static UserStorage instance;

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }

    @Override
    public User findById(long id) {
        return Optional.ofNullable(entities.get(id))
                .orElseThrow(() -> new RuntimeException("Entity not found"));

    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public void deleteAll() {
        entities.clear();
    }

    private void updateUser(User user) {
        user.update();
        entities.put(user.getId(), user);
    }

    private void createUser(User user) {
        user.addId(gen.getId());
        entities.put(user.getId(), user);
    }

}
