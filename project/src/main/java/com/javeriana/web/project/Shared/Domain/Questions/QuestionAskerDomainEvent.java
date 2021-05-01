package com.javeriana.web.project.Shared.Domain.Questions;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;
import com.javeriana.web.project.Shared.Domain.Offers.OfferCreatorDomainEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

public class QuestionAskerDomainEvent extends DomainEvent {

    private final  String text;
    private final String propertyID;
    private final LocalDate date;
    private final String answer;

    public QuestionAskerDomainEvent(){
        super(null);
        this.text = null;
        this.propertyID = null;
        this.date = null;
        this.answer = null;
    }

    public QuestionAskerDomainEvent(String aggregateId, String text, String propertyID, LocalDate date) {
        super(aggregateId);
        this.text = text;
        this.propertyID = propertyID;
        this.date = date;
        this.answer = "";
    }

    public QuestionAskerDomainEvent(String aggregateId, String eventId, String occurredOn, String text, String propertyID, LocalDate date) {
        super(aggregateId, eventId, occurredOn);
        this.text = text;
        this.propertyID = propertyID;
        this.date = date;
        this.answer = "";
    }

    @Override
    public String eventName() {
        return "question.asker";
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
        return new QuestionAskerDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("propertyID"),
                (String) body.get("text"),
                (LocalDate) body.get("date"));
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionAskerDomainEvent that = (QuestionAskerDomainEvent) o;
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
