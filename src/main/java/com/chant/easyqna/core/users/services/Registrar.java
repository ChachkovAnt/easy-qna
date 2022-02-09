package com.chant.easyqna.core.users.services;

import com.chant.easyqna.core.users.models.User;
import com.chant.easyqna.core.users.repositories.UserRepository;
import com.chant.easyqna.core.users.vo.UserData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Registrar {

    private final UserRepository userRepository;

    public void register(UserData data) {
        userRepository.save(new User(data));
    }

}
