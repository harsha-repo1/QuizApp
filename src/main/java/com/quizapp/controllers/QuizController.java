package com.quizapp.controllers;

import com.quizapp.Question;
import com.quizapp.QuestionWrapper;
import com.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<?> createQuiz(@RequestParam String title ,@RequestParam int Qno , @RequestParam String category  ){

        return     quizService.createQuiz(title,Qno,category);


    }
    @GetMapping("/get/{no}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable int no){
        return quizService.getQuestions(no);

    }

}
