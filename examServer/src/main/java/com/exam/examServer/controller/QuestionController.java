package com.exam.examServer.controller;
import com.exam.examServer.Models.exam.Question;
import com.exam.examServer.Models.exam.Quiz;
import com.exam.examServer.service.QuestionService;
import com.exam.examServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public Question addQuestion(@RequestBody Question question)
    {
        return this.questionService.addQuestion(question);
    }

    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question)
    {
        return this.questionService.updateQuestion(question);
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qId)
    {
        Optional<Quiz> quiz=this.quizService.getQuiz(qId);
        Set<Question>questions=quiz.get().getQuestions();
        List list=new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.get().getNumberOfQuestion())){
            list=list.subList(0,Integer.parseInt(quiz.get().getNumberOfQuestion()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{questionId}")
    public Optional<Question> getQuestion(@PathVariable("questionID") Long id)
    {
        return this.questionService.getQuestion(id);
    }

    @GetMapping("/")
    public Set<Question> getQuestions()
    {
        return this.questionService.getQuestions();
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long id)
    {
        this.questionService.deleteQuestion(id);
    }

}
