package com.javeriana.web.project.PropertiesTest.OfferTests.ValueObjects;

import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Shared.Domain.OfferActionEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
    @Test
    void should_not_throw_exceptions_arriendo() {
        assertAll(() -> new Action(OfferActionEnum.ARRIENDO));
    }

    @Test
    void should_not_throw_exceptions_venta() {
        assertAll(() -> new Action(OfferActionEnum.VENTA));
    }
}
