package com.exam.examServer.repo;

import com.exam.examServer.Models.exam.Question;
import com.exam.examServer.Models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> getByQuiz(Quiz quiz);
}
