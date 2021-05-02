package com.javeriana.web.project.Properties.Property.Infraestructure.hibernate;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.SerializedOffer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernatePropertyRepository  implements PropertyRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Property> aggregateClass;

    public HibernatePropertyRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Property.class;
    }

    @Override
    public void save(Property property) {
        sessionFactory.getCurrentSession().save(property);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Property> find(String propertyId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(propertyId));
    }

    @Override
    public Property updateSerializedOffer(String propertyId, Property property) {
        sessionFactory.getCurrentSession().saveOrUpdate(propertyId,property);
        return sessionFactory.getCurrentSession().byId(aggregateClass).load(propertyId);
    }

    public void update(String propertyId, Property property) {

    }

}
