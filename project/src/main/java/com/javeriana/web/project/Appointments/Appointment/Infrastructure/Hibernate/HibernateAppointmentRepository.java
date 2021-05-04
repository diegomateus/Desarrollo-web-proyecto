package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Hibernate;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
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

    public Optional<Appointment> find(String appointmentId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(appointmentId));
    }

    @Override
    public Appointment assignEmployee(String appointmentId, Appointment appointment) {
        sessionFactory.getCurrentSession().saveOrUpdate(appointmentId,appointment);
        return sessionFactory.getCurrentSession().byId(aggregateClass).load(appointmentId);
    }

    @Override
    public Optional<List<Appointment>> findAssignedAppointmets(String employeeId) {
        ArrayList<Appointment> todos = (ArrayList<Appointment>) all().get();
        if(todos.isEmpty()){
            return Optional.empty();
        }
        ArrayList<Appointment> assigned = new ArrayList<>();
        for(Appointment a : todos){
            if(!a.getAssignedEmployee().isEmpty()){
                if(a.getAssignedEmployee().get().get("id").equals(employeeId)){
                    assigned.add(a);
                }
            }
        }
        return Optional.ofNullable(assigned);
    }

    @Override
    public Optional<List<Appointment>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From appointmets");
        return Optional.ofNullable(query.list());
    }

}
