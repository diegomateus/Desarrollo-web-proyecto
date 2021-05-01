/*package com.javeriana.web.project.Employees.Employee.Infrastructure.hibernate;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactional-manager")
public class HibernateEmployeeRepository implements EmployeeRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Employee> aggregateClass;

    public HibernateEmployeeRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Employee.class;
    }


    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}*/
