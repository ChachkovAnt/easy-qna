package com.chant.easyqna.storage;

import com.chant.easyqna.core.questions.models.Author;
import com.chant.easyqna.core.questions.repositories.AuthorRepository;
import com.chant.easyqna.core.users.vo.UserData;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorStorage implements AuthorRepository {

    private final UserStorage userStorage = UserStorage.getInstance();

    @Override
    public void save(Author author) {
        var user = userStorage.findById(author.getId());
        var data = new UserData(
                author.getFirstName(),
                author.getLastName(),
                user.getData().login(),
                user.getData().password());
        user.updateData(data);
        userStorage.save(user);
    }

    @Override
    public Author findById(long id) {
        var user = userStorage.findById(id);
        return new Author(
                user.getId(),
                user.getData().firstName(),
                user.getData().lastName());
    }

    @Override
    public List<Author> findAll() {
        return userStorage.findAll()
                .stream()
                .map(user -> new Author(
                        user.getId(),
                        user.getData().firstName(),
                        user.getData().lastName()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        userStorage.deleteAll();
    }
}
