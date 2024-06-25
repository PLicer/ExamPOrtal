package com.exam.examServer.repo;

import com.exam.examServer.Models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
    void deleteByQid(Long qid);
}
