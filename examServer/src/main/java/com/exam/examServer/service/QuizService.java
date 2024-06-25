package com.exam.examServer.service;

import com.exam.examServer.Models.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> qetQuizzes();
    public Optional<Quiz> getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);


}
