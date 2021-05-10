package com.javeriana.web.project.Properties.Property.Infrastructure.hibernate;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PropertyId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
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
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(new PropertyId(propertyId)));
    }

    @Override
    public List<Property> filter(List<String> idPropiedades, String propertyType, String city,
                                 int bedRoomsNumber, int bathRoomNumber, String propertyCondition) {

        List<Property> prop = new ArrayList<>();
        List<Property> todas = all().get();
        List<Property> res = new ArrayList<>();


        if(!idPropiedades.isEmpty()){
            for(Property p : todas ){
                if(idPropiedades.contains(p.getPropertyId().value())){
                    prop.add(p);
                }
            }
        }else{
            prop = todas;
        }

        prop = todas;
        if(!city.equals("")){
            for(Property p : prop){
                if(!city.equals(p.getCity().value())){
                    prop.remove(p);
                }

            }
        }

        if(!propertyType.equals("")){
            for(Property p : prop){
                if(!propertyType.equals(p.getPropertyType().value())){
                    prop.remove(p);
                }
            }
        }
        if(!propertyCondition.equals("")){
            for(Property p : prop){
                if(!propertyCondition.equals(p.getCondition().value())){
                    prop.remove(p);
                }
            }
        }
        if(bedRoomsNumber != 0){
            for(Property p : prop){
                if(p.getBedroomsNumber().value() < bedRoomsNumber){
                    prop.remove(p);
                }
            }
        }
        if(bathRoomNumber != 0){
            for(Property p : prop){
                if(p.getBathroomsNumber().value() < bathRoomNumber){
                    prop.remove(p);
                }
            }
        }

        return res;
    }

    @Override
    public Optional<List<Property>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Property");
        return Optional.ofNullable(query.list());
    }

    public void update(String propertyId, Property property) {
        sessionFactory.getCurrentSession().update(propertyId,property);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    public void delete(Property property){
        sessionFactory.getCurrentSession().delete(property);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

}
