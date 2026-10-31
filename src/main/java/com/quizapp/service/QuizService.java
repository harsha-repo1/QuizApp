package com.quizapp.service;

import com.quizapp.Question;
import com.quizapp.QuestionWrapper;
import com.quizapp.Quiz;
import com.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;


    public ResponseEntity<?> createQuiz(String title, Integer qno, String category) {
        Quiz quiz =  new Quiz();
        List<Question> questions = quizRepository.getQuestionswithcount(qno,category);
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return  new ResponseEntity<>("success",HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(int no) {
        Optional<Quiz> quiz = quizRepository.findById(no);
        List<Question> qfromdb = quiz.get().getQuestions();
        List<QuestionWrapper> qforuser = new ArrayList<>();
        for(Question q:qfromdb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            qforuser.add(qw);
        }
        return  new ResponseEntity<>( qforuser,HttpStatus.OK);

    }
}
