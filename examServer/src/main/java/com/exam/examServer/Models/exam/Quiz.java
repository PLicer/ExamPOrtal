package com.exam.examServer.Models.exam;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long qid;

    private String title;

    private String description;

    private String maxMarks;

    private String numberOfQuestion;

    private boolean active=false;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Category category;

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    public Set<Question>questions=new HashSet<>();

    public Quiz() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(String numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Quiz(String title, String numberOfQuestion, String maxMarks, boolean active, String description) {
        this.title = title;
        this.numberOfQuestion = numberOfQuestion;
        this.maxMarks = maxMarks;
        this.active = active;
        this.description = description;
    }
}
