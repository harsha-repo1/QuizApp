package com.quizapp.repository;

import com.quizapp.Question;
import com.quizapp.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    @Query(value = " SELECT * FROM question WHERE category = :category  ORDER BY RAND() LIMIT :Qno", nativeQuery = true)
    List<Question> getQuestionswithcount(int Qno, String category);

}
