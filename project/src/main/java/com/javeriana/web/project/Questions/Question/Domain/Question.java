package com.javeriana.web.project.Questions.Question.Domain;

import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Bus.Aggregate.AggregateRoot;
import com.javeriana.web.project.Shared.Domain.Questions.QuestionCreatorDomainEvent;

import java.io.Serializable;

public class Question extends AggregateRoot implements Serializable {


    private QuestionId questionId;
    private PropertyId propertyId;
    private QuestionDate date;
    private Text text;
    private Answer answer;

    public Question(QuestionId questionId, PropertyId propertyId, Text text, QuestionDate date,Answer answer) {
        this.date = date;
        this.propertyId = propertyId;
        this.questionId = questionId;
        this.text = text;
        this.answer = answer;
        this.record(new QuestionCreatorDomainEvent(questionId.value(),propertyId.value(),text.value(),date.value(),answer.value()));
    }

    public Question(QuestionId questionId, PropertyId propertyId, Text text, QuestionDate date) {
        this.date = date;
        this.propertyId = propertyId;
        this.questionId = questionId;
        this.text = text;
        this.answer = null;
        this.record(new QuestionCreatorDomainEvent(questionId.value(),propertyId.value(),text.value(),date.value(),""));
    }

    public Question askQuestion(QuestionId questionId, PropertyId propertyId,QuestionDate date, Text text){
        Question question = new Question(questionId,propertyId,text, date);
        this.record(new QuestionCreatorDomainEvent(questionId.value(),propertyId.value(),text.value(),date.value(),""));
        return question;
    }

    public QuestionDate getDate() {
        return date;
    }

    public PropertyId getPropertyId() {
        return propertyId;
    }

    public QuestionId getQuestionId() {
        return questionId;
    }

    public Text getText() {
        return text;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void answerQuestion(Answer answer){
        this.answer = answer;
    }
}
