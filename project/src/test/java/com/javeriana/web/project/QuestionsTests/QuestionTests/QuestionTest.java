package com.javeriana.web.project.QuestionsTests.QuestionTests;

import com.javeriana.web.project.Questions.Question.Application.CreateQuestion.QuestionCreator;
import com.javeriana.web.project.Questions.Question.Domain.Ports.QuestionRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class QuestionTest {

    @Test
    void should_create_question(){
        QuestionRepository repository = mock(QuestionRepository.class);
        QuestionCreator creator = new QuestionCreator(repository);
    }

    @Test
    void should_answer_question(){

    }
}
