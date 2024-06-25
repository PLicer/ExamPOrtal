package com.exam.examServer.service;

import com.exam.examServer.Models.exam.Question;
import com.exam.examServer.Models.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public interface QuestionService {

    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Optional<Question> getQuestion(Long questionId);
    public Set<Question>getQuestionOfQuiz(Quiz quiz);
    public void deleteQuestion(Long id);

}
