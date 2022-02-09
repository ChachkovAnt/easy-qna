package com.chant.easyqna.core.questions.models;

import lombok.Data;

@Data
public class Author {

    private final Long id;
    private final String firstName;
    private final String lastName;

    public Question createQuestion(String title, String text) {
        return new Question(title, text, this);
    }

    public void answerTheQuestion(Question question, String text) {
        question.addAnswer(text, this);
    }

}
