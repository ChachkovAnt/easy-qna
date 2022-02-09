package com.chant.easyqna.storage;

import com.chant.easyqna.core.questions.models.Question;
import com.chant.easyqna.core.questions.repositories.QuestionRepository;

import java.util.List;

public class QuestionStorage extends Storage<Question> implements QuestionRepository {

    private static QuestionStorage instance;

    public static QuestionStorage getInstance() {
        if (instance == null) {
            instance = new QuestionStorage();
        }
        return instance;
    }

    @Override
    public void save(Question question) {
        var id = gen.getId();
        entities.put(id, new Question(id, question));
    }

    @Override
    public Question findById(long id) {
        return null;
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
