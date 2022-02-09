package com.chant.easyqna.core.questions.models;

import lombok.Getter;

@Getter
public class Answer {

    private Long id;
    private final Question question;
    private final Note note;

    public Answer(Question question, String text, Author author) {
        this.question = question;
        this.note = new Note(text, author);
    }
}
