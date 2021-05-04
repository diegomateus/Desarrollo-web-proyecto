package com.javeriana.web.project.Questions.Question.Domain.Services;

import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.UnAnsweredQuestionsNotExist;

import java.util.List;

public class UnAnsweredQuestionsFinder {

    private QuestionRepository repository;

    public UnAnsweredQuestionsFinder(QuestionRepository repository) {
        this.repository = repository;
    }

    public List execute(){
        List questions = repository.findUnAnsweredQuestions().get();
        if(questions.isEmpty()){
            throw new UnAnsweredQuestionsNotExist("There are no unanswered questions");
        }
        return questions;
    }
}
