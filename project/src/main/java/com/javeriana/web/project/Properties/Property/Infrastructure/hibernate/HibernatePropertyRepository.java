package com.javeriana.web.project.Properties.Property.Infrastructure.hibernate;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<Property> filter(BedroomsNumber minBedroomsNumber,
                                 BathroomsNumber minBathroomsNumber,
                                 BuiltArea minBuiltArea, BuiltArea maxBuiltArea,
                                 Condition condition,
                                 PrivateArea minPrivateArea, PrivateArea maxPrivateArea
    ) {
        //sessionFactory.getCurrentSession()
        List<Property> prop = all().get();
        List<Property> filtradas = new ArrayList<>();
        if(condition != null){
            for(Property p : prop){
                if(!condition.equals(p.getCondition())){
                    prop.remove(p);
                }
            }
        }
        if(minBedroomsNumber != null){
            for(Property p : prop){
                if(p.getBedroomsNumber().value() < minBedroomsNumber.value()){
                    prop.remove(p);
                }
            }
        }
        if(minBathroomsNumber != null){
            for(Property p : prop){
                if(p.getBathroomsNumber().value() < minBathroomsNumber.value()){
                    prop.remove(p);
                }
            }
        }
        if(minBuiltArea.value() != 0 || maxBuiltArea.value() != 100000){
            for(Property p : prop){
                if(minBuiltArea.value() > p.getBuiltArea().value() && p.getBuiltArea().value() > maxBuiltArea.value()){
                    prop.remove(p);
                }
            }
        }
        if(minPrivateArea.value() != 0 || maxPrivateArea.value() != 100000){
            for(Property p : prop){
                if(minPrivateArea.value() > p.getPrivateArea().value() && p.getPrivateArea().value() > maxPrivateArea.value()){
                    prop.remove(p);
                }
            }
        }


        return prop;
    }

    @Override
    public Optional<List<Property>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From property");
        return Optional.ofNullable(query.list());
    }

    public void update(String propertyId, Property property) {

    }

}
