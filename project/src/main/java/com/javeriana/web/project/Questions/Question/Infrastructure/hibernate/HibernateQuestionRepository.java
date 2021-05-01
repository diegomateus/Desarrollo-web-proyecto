package com.javeriana.web.project.Questions.Question.Infrastructure.hibernate;


import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactional-manager")
public class HibernateQuestionRepository implements QuestionRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Question> aggregateClass;

    public HibernateQuestionRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Question.class;
    }


    @Override
    public void save(Question question) {
        sessionFactory.getCurrentSession().save(question);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

}
