package com.javeriana.web.project.Properties.Property.Application.FilterProperties;

import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Questions.Question.Domain.Question;

public class FilterProperties {

    private PropertyRepository repository;
    private PropertiesFilterer propertiesFilterer;

    public FilterProperties(PropertyRepository repository, PropertiesFilterer propertiesFilterer) {
        this.repository = repository;
        this.propertiesFilterer = propertiesFilterer;
    }

    public List<Question> execute(){

    }
}
