package com.javeriana.web.project.Shared.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends StringValueObject{
    public Email(String value) {
        super(value);
        this.validate(value);
    }

    private void validate(String value) {
        this.regexRule(value);
    }

    private void regexRule(String value) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        if(!matcher.matches()) {
            throw new InvalidEmail("Invalid email");
        }
    }
}
