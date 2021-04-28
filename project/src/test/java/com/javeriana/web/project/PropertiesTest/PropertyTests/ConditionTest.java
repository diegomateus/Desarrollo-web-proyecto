package com.javeriana.web.project.PropertiesTest.PropertyTests;

import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.Condition;
import com.javeriana.web.project.Shared.Domain.PropertyConditionEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ConditionTest {
    @Test
    void should_not_throw_exceptions_NUEVO() {
        assertAll(() -> new Condition(PropertyConditionEnum.NUEVO));
    }

    @Test
    void should_not_throw_exceptions_REMODELADO() {
        assertAll(() -> new Condition(PropertyConditionEnum.REMODELADO));
    }

    @Test
    void should_not_throw_exceptions_USADO() {
        assertAll(() -> new Condition(PropertyConditionEnum.USADO));
    }
}
