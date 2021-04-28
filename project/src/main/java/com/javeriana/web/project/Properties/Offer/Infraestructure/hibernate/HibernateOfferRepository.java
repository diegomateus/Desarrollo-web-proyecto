package com.javeriana.web.project.Properties.Offer.Infraestructure.hibernate;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactional-manager")
public class HibernateOfferRepository implements OfferRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Offer> aggregateClass;

    public HibernateOfferRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Offer.class;
    }


    @Override
    public void save(Offer offer) {
        sessionFactory.getCurrentSession().save(offer);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
    //TODO: revisar manyToOne de propertyId dentro de Offer en hbm.xml

}