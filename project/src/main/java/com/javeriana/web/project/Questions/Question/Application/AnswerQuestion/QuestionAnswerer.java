package com.javeriana.web.project.Questions.Question.Application.AnswerQuestion;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;
import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import com.javeriana.web.project.Questions.Question.Domain.Services.QuestionDomainFinder;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;

import java.util.Optional;

public class QuestionAnswerer {

    private QuestionRepository repository;
    private QuestionDomainFinder questionDomainFinder;
    private EventBus eventBus;

    public QuestionAnswerer(QuestionRepository repository, QuestionDomainFinder questionDomainFinder, EventBus eventBus) {
        this.repository = repository;
        this.questionDomainFinder = questionDomainFinder;
        this.eventBus = eventBus;
    }

    public Question execute(String questionId, String answer, Question question){
        Optional<Question> actualQuestion= questionDomainFinder.execute(questionId);
        question.answerQuestion(question);
        repository.update(questionId,question);
        return question;
    }
}
