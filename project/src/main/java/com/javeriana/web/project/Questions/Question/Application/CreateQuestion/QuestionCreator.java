package com.javeriana.web.project.Questions.Question.Application.CreateQuestion;

import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.time.LocalDate;

public class QuestionCreator {

    private QuestionRepository repository;
    private EventBus eventBus;




    public QuestionCreator(QuestionRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String questionId, String propertyId, String text, LocalDate date){
        //TODO: Verificar existencia de propiedad
        Question question = Question.askQuestion(new QuestionId(questionId),new PropertyId(propertyId),new QuestionDate(date), new Text(text));
        repository.save(question);
        this.eventBus.publish(question.pullDomainEvents());
    }

}
