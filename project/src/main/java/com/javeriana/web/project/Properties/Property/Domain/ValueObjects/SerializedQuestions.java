package com.javeriana.web.project.Properties.Property.Domain.ValueObjects;

import com.javeriana.web.project.Questions.Question.Question;

import java.util.ArrayList;

public class SerializedQuestions {
    private ArrayList<Question> value;

    public SerializedQuestions(ArrayList<Question> value) {
        this.value = value;
    }

    public ArrayList<Question> value(){
        return this.value;
    }
}
