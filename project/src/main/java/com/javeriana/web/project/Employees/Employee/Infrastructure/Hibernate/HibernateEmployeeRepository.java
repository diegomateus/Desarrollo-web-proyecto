package com.javeriana.web.project.Employees.Employee.Infrastructure.Hibernate;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeePassword;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateEmployeeRepository implements EmployeeRepository {
    private final int STRENGTH = 12;
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

    @Override
    public Optional<Employee> authenticate(String email, String password) {
        Optional<Employee> searchedEmployee = this.getByEmail(email);
        if (searchedEmployee.isPresent()) {
            Employee employee = searchedEmployee.get();
            //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(STRENGTH);
            //if (encoder.matches(password, employee.data().get("password"))) {
            if (password.equals(employee.data().get("password"))) {
                return searchedEmployee;
            }
        }
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Employee> getByEmail(String email) {
        try {
            String sql = "SELECT * FROM EMPLOYEES WHERE email = :employee_email";
            NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
            query.addEntity(Employee.class);
            query.setParameter("employee_email",email);
            return Optional.ofNullable((Employee) query.getSingleResult());
        }
        catch (Exception e) {
            return Optional.ofNullable(null);
        }
    }
}
