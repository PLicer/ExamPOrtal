package com.exam.examServer.service.impl;

import com.exam.examServer.Models.exam.Question;
import com.exam.examServer.Models.exam.Quiz;
import com.exam.examServer.repo.QuestionRepository;
import com.exam.examServer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        List<Question> questionList=this.questionRepository.findAll();
        return new HashSet<>(questionList);
    }

    @Override
    public Optional<Question> getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId);
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.getByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long id) {
        this.questionRepository.deleteById(id);
    }
}
