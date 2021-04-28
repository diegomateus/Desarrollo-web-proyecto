package com.javeriana.web.project.Shared.Domain;

import java.time.DateTimeException;

public class InvalidDate extends DateTimeException {
    public InvalidDate(String message) {
        super(message);
    }
}
