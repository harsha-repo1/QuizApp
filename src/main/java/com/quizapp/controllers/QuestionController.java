package com.quizapp.controllers;

import com.quizapp.Question;
import com.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")

public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("getall")
    public ResponseEntity<List<Question>> printMsg() {
     return   questionService.getAllQuestions() ;
    }
    @GetMapping("/category/{cat}")

    public ResponseEntity<List<Question>> categorySearch(@PathVariable String cat){
        return questionService.getByCategory(cat);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody  Question question){
        return questionService.saveQuestion(question);
    }

}
