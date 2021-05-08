package com.javeriana.web.project.Appointments.Appointment.Infrastructure.DomainEventSubscribers;

import com.javeriana.web.project.Appointments.Appointment.Application.Cancel.CancelAppointment;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Employees.EmployeeDeletedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({EmployeeDeletedDomainEvent.class})
public class CancelAppointmentOnEmployeeDeleted {

    private CancelAppointment cancelAppointment;

    public CancelAppointmentOnEmployeeDeleted(CancelAppointment cancelAppointment) {
        this.cancelAppointment = cancelAppointment;
    }

    @EventListener
    public void on(EmployeeDeletedDomainEvent event) {
        this.cancelAppointment.execute(event.aggregateId());
    }

}
