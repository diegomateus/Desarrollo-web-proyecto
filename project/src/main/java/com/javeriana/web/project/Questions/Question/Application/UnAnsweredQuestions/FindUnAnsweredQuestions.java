package com.javeriana.web.project.Questions.Question.Application.UnAnsweredQuestions;

import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.Services.UnAnsweredQuestionsFinder;

import java.util.List;

public class FindUnAnsweredQuestions {

    private QuestionRepository repository;
    private UnAnsweredQuestionsFinder unAnsweredQuestionsFinder;

    public FindUnAnsweredQuestions(QuestionRepository repository, UnAnsweredQuestionsFinder unAnsweredQuestionsFinder) {
        this.repository = repository;
        this.unAnsweredQuestionsFinder = unAnsweredQuestionsFinder;
    }

    public List<Question> execute(){
        return unAnsweredQuestionsFinder.execute();
    }
}
