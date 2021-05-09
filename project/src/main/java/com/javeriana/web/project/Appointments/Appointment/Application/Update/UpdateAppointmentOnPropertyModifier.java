package com.javeriana.web.project.Appointments.Appointment.Application.Update;

import com.javeriana.web.project.Appointments.Appointment.Application.Book.AppointmentBooker;
import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyModifierDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({PropertyModifierDomainEvent.class})
public final class UpdateAppointmentOnPropertyModifier {

    //private AppointmentModifier appointmentModifier;
    private AppointmentBooker appointmentModifier;
    public UpdateAppointmentOnPropertyModifier(AppointmentBooker appointmentModifier){
        this.appointmentModifier = appointmentModifier;
    }
    @EventListener
    public void on(PropertyModifierDomainEvent event){
        System.out.println("se metio al modificar");
        //this.appointmentBooker.execute(event.aggregateId(),event.getPropertyId(),event.);
    }
}
