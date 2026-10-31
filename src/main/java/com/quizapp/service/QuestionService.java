package com.quizapp.service;
import java.util.ArrayList;
import java.util.List;

import com.quizapp.Question;
import com.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestions() {
try {
     return new  ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);

}catch (Exception e){
    e.printStackTrace();
}
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getByCategory(String cat) {
        return new ResponseEntity<>(questionRepository.findByCategory(cat),HttpStatus.OK);
    }

    public ResponseEntity<String> saveQuestion( Question question) {
         questionRepository.save(question);
         return new ResponseEntity<>("success",HttpStatus.CREATED);

    }
}
