package com.javeriana.web.project.Questions.Question.Domain.Ports;

import com.javeriana.web.project.Questions.Question.Domain.Question;

public interface QuestionRepository {

    void save(Question question);
    //TODO: Add other methods
}
