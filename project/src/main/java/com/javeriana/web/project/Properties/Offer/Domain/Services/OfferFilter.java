package com.javeriana.web.project.Properties.Offer.Domain.Services;

import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;

import java.util.List;

public class OfferFilter {

    private OfferRepository repository;

    public OfferFilter(OfferRepository repository) {
        this.repository = repository;
    }

    public List<String> execute(int priceLowerLimit, int priceUpperLimit, String action) {
        List<String> propiedades = repository.filter(priceLowerLimit,priceUpperLimit, action);

        return propiedades;
    }
}
