package com.javeriana.web.project.Shared.Domain.Questions;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

public class QuestionAnswererDomainEvent extends DomainEvent {


    private final  String text;
    private final String propertyID;
    private final LocalDate date;
    private final String answer;

    public QuestionAnswererDomainEvent(String aggregateId, String text, String propertyID, LocalDate date, String answer) {
        super(aggregateId);
        this.text = text;
        this.propertyID = propertyID;
        this.date = date;
        this.answer = answer;
    }

    public QuestionAnswererDomainEvent(String aggregateId, String eventId, String occurredOn, String text, String propertyID, LocalDate date, String answer) {
        super(aggregateId, eventId, occurredOn);
        this.text = text;
        this.propertyID = propertyID;
        this.date = date;
        this.answer = answer;
    }

    public QuestionAnswererDomainEvent() {
        this.text = null;
        this.propertyID = null;
        this.date = null;
        this.answer = null;
    }

    @Override
    public String eventName() {
        return "question.answer";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("propertyID",propertyID);
            put("text",text);
            put("date",date);
            put("answer",answer);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new QuestionAnswererDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("propertyID"),
                (String) body.get("text"),
                (LocalDate) body.get("date"),
                (String) body.get("answer"));
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionAnswererDomainEvent that = (QuestionAnswererDomainEvent) o;
        return Objects.equals(that.text, text)  && Objects.equals(propertyID, that.propertyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, propertyID, date);
    }

    public String getText() {
        return text;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public LocalDate getDate() {
        return date;
    }
}
