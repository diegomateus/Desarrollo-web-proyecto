/*package com.javeriana.web.project.Properties.Property.Infraestructure.hibernate;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

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
}
*/