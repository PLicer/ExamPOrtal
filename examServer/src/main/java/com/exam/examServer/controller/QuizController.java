package com.exam.examServer.controller;


import com.exam.examServer.Models.exam.Quiz;
import com.exam.examServer.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return this.quizService.addQuiz(quiz);
    }

    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return this.quizService.updateQuiz(quiz);
    }

    @GetMapping("/{quizId}")
    public Optional<Quiz> quiz(@PathVariable("quizId") Long id){
        return this.quizService.getQuiz(id);
    }

    @GetMapping("/")
    public Set<Quiz>quizzes()
    {
        return this.quizService.qetQuizzes();
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId)
    {
        try
        {
            this.quizService.deleteQuiz(quizId);
        }
         catch (Exception exception)
         {
             System.out.println(exception.getMessage());
         }
    }

}
