package com.javeriana.web.project.Questions.Question.Infrastructure.Controllers;


import com.javeriana.web.project.Questions.Question.Application.AnswerQuestion.QuestionAnswerer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/questions")
public class SubmitAnswerController {
    @Autowired
    QuestionAnswerer answerer;

    @PutMapping(value="/{questionId}")
    public ResponseEntity execute(@RequestBody Request request, @PathVariable("questionId") String id){
        answerer.execute(id, request.getText());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    static class Request{
        private String text;

        Request(){

        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
