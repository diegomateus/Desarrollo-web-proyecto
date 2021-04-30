package com.javeriana.web.project.PropertiesTest.OfferTests.Unit;

import com.javeriana.web.project.Properties.Offer.Application.CreateOffer.OfferCreator;
import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Domain.OfferActionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OfferTest {

    @Test
    void should_create_offer(){
        OfferRepository repository=mock(OfferRepository.class);
        OfferCreator offer= new OfferCreator(repository);

        Offer actualOffer = new Offer(new OfferId("A"),new PropertyId("B"),new Price(123),new Action(OfferActionEnum.ARRIENDO));

        verify(repository, atLeastOnce()).save(actualOffer);
    }
}
