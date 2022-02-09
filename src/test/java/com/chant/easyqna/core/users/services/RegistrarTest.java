package com.chant.easyqna.core.users.services;

import com.chant.easyqna.core.users.models.User;
import com.chant.easyqna.core.users.repositories.UserRepository;
import com.chant.easyqna.core.users.vo.UserData;
import com.chant.easyqna.storage.UserStorage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RegistrarTest {

    private final Faker faker = Faker.instance();
    private Registrar registrar;
    private UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        userRepository = UserStorage.getInstance();
        registrar = new Registrar(userRepository);
    }

    @Test
    void register() {
        var expectedUserData = new UserData(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password());
        registrar.register(expectedUserData);

        var usersList = userRepository.findAll();
        var actualUser = usersList.get(0);

        assertNotNull(actualUser);
        assertAll(
                () -> assertEquals(1, usersList.size()),
                () -> assertEquals(expectedUserData, actualUser.getData()),
                () -> assertNotNull(actualUser.getCreated()),
                () -> assertNotNull(actualUser.getUpdated()),
                () -> assertNotNull(actualUser.getId())
        );
    }

    @Test
    void registerNewUserWithExistedOne() {
        var existedUser = new User(
                new UserData(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.internet().password()));
        userRepository.save(existedUser);

        var expectedUserData = new UserData(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password());
        registrar.register(expectedUserData);

        var usersList = userRepository.findAll();
        var actualUser = usersList.stream()
                .filter(user -> !Objects.equals(user.getId(), existedUser.getId()))
                .findFirst()
                .orElse(existedUser);

        assertNotNull(actualUser);
        assertAll(
                () -> assertEquals(2, usersList.size()),
                () -> assertEquals(expectedUserData, actualUser.getData()),
                () -> assertNotNull(actualUser.getCreated()),
                () -> assertNotNull(actualUser.getUpdated()),
                () -> assertNotNull(actualUser.getId())
        );
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }
}