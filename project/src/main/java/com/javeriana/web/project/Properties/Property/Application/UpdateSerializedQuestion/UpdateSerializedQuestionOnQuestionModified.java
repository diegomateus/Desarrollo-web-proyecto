package com.javeriana.web.project.Properties.Property.Application.UpdateSerializedQuestion;

import com.javeriana.web.project.Shared.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.project.Shared.Domain.Questions.QuestionAnsweredDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({QuestionAnsweredDomainEvent.class})
public class UpdateSerializedQuestionOnQuestionModified {
    private UpdateSerializedQuestion updateSerializedQuestion;

    public UpdateSerializedQuestionOnQuestionModified(UpdateSerializedQuestion updateSerializedQuestion) {
        this.updateSerializedQuestion = updateSerializedQuestion;
    }

    @EventListener
    public void on(QuestionAnsweredDomainEvent event){
        updateSerializedQuestion.execute(event.getPropertyId(),event.aggregateId(), event.getText(),event.getDate().toString(),event.getAnswer());
    }
}
