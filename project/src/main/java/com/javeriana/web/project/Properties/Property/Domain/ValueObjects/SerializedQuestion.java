package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Questions.Question.Question;

import java.util.HashMap;
import java.util.Objects;

public class SerializedQuestion {
    private String questionId;
    private Question question;

    public SerializedQuestion() {
    }

    public SerializedQuestion(String questionId, Question question) {
        this.questionId = questionId;
        this.question = question;
    }

    public Question value(){
        return this.question;
    }

    public HashMap<String,Object> data(){
        HashMap<String, Object> data= new HashMap<>(){{
            put("id",questionId);
            put("question",question);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializedQuestion that = (SerializedQuestion) o;
        return Objects.equals(questionId, that.questionId) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, question);
    }
}
