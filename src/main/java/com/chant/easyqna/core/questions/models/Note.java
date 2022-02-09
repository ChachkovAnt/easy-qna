package com.chant.easyqna.core.questions.models;

import com.chant.easyqna.core.questions.models.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Note {

    private String title;
    private final String text;
    private final Author author;

}
