package com.javeriana.web.project.Questions.Question.Domain.Ports;

import com.javeriana.web.project.Questions.Question.Domain.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    void save(Question question);
    Optional<Question> find(String questionId);
    Question update(String questionId, Question question);

    List findUnAnsweredQuestions();
    //TODO: Add other methods

}
