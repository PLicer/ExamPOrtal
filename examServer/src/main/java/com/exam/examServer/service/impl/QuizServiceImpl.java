package com.exam.examServer.service.impl;

import com.exam.examServer.Models.exam.Quiz;
import com.exam.examServer.repo.QuizRepository;
import com.exam.examServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> qetQuizzes() {
        List<Quiz>quiz= this.quizRepository.findAll();
        return new HashSet<>(quiz);
    }

    @Override
    public Optional<Quiz> getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId);
    }

    @Override
    @Transactional
    public void deleteQuiz(Long qid) {

        this.quizRepository.deleteById(qid);

    }
}