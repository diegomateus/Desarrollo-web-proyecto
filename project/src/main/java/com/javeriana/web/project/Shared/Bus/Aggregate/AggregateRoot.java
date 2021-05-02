package com.javeriana.web.project.Shared.Bus.Aggregate;

import com.javeriana.web.project.Shared.Bus.Event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {

    private List<DomainEvent> domainEvents = new ArrayList<>();

    final public List<DomainEvent> pullDomainEvents(){
        List<DomainEvent> events= this.domainEvents;
        this.domainEvents = Collections.emptyList();
        return events;
    }

    final protected void record(DomainEvent event){
        this.domainEvents.add(event);
    }

}
