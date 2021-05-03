package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Hibernate;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import org.hibernate.SessionFactory;
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
        //TODO
        return null;
    }

}
