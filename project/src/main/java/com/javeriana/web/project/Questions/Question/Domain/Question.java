package com.javeriana.web.project.Questions.Question.Domain;

import com.javeriana.web.project.Questions.Question.Domain.ValueObjects.*;

public class Question {

    private QuestionDate date;
    private PropertyId propertyId;
    private QuestionId questionId;
    private Text text;
    private Answer answer;

    public Question(QuestionDate date, PropertyId propertyId, QuestionId questionId, Text text, Answer answer) {
        this.date = date;
        this.propertyId = propertyId;
        this.questionId = questionId;
        this.text = text;
        this.answer = answer;
    }
}
