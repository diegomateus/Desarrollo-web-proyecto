package com.javeriana.web.project.Shared.Domain;

import java.util.Calendar;

public class CalendarValueObject {
    private Calendar value;

    public CalendarValueObject(Calendar value) {
        this.value = value;
    }

    public Calendar value(){
        return value;
    }
}
