package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Hibernate;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class HibernateAppointmentRepository implements AppointmentRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Appointment> aggregateClass;

    public HibernateAppointmentRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Appointment.class;
    }

    @Override
    public void save(Appointment appointment) {
        sessionFactory.getCurrentSession().save(appointment);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public List<Appointment> getUnassignedAppointments() {
        String sql = "SELECT * FROM appointments WHERE assigned_employee IS NULL";
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Appointment.class);
        return (List<Appointment>) query.getResultList();
    }

}
