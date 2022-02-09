package com.chant.easyqna.core.questions.services;

import com.chant.easyqna.core.questions.repositories.AuthorRepository;
import com.chant.easyqna.core.questions.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuestionCases {

    private final AuthorRepository authorRepository;
    private final QuestionRepository questionRepository;

    public void askQuestion(Long authorId, String title, String text) {
        var author = authorRepository.findById(authorId);
        var question = author.createQuestion(title, text);
        questionRepository.save(question);
    }

    public void answerTheQuestion(Long authorId, Long questionId, String text) {
        var author = authorRepository.findById(authorId);
        var question = questionRepository.findById(questionId);
        question.addAnswer(text, author);

        questionRepository.save(question);
    }
}
