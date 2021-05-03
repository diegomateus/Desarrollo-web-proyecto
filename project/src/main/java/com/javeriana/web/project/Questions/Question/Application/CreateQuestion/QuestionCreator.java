package com.javeriana.web.project.Questions.Question.Application.CreateQuestion;

import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.Services.QuestionDomainFinder;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.time.LocalDate;

public class QuestionCreator {

    private QuestionRepository repository;
    private QuestionDomainFinder questionDomainFinder;




    public QuestionCreator(QuestionRepository repository) {
        this.repository = repository;
        this.questionDomainFinder = new QuestionDomainFinder(repository);
    }

    public void execute(String questionId, String propertyId, String text, LocalDate date){
        validate(questionId);
        Question question = Question.askQuestion(new QuestionId(questionId),new PropertyId(propertyId),new QuestionDate(date), new Text(text));
        repository.save(question);
    }

    private void validate(String questionId){
        try{

        }catch(Exception e){

        }
    }

}
