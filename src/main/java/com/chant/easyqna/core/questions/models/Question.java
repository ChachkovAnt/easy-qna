package com.chant.easyqna.core.questions.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Question {

    private Long id;
    private final Note note;
    private List<Answer> answers = new ArrayList<>();
    private Date created;
    private Date updated;

    public Question(String title, String text, Author author) {
        this.note = new Note(title, text, author);
    }

    public Question(long id, Question question) {
        this.id = id;
        this.note = question.getNote();
        this.created = new Date();
        this.updated = new Date();
    }

    public void addAnswer(String text, Author author) {
        this.answers.add(
                new Answer(this, text, author));
    }

}

