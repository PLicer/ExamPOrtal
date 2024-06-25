package com.exam.examServer.Models.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {

    public Category(long cid, String description, String title) {
        this.cid = cid;
        this.description = description;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cid;

    private String title;

    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Quiz>quizzes=new LinkedHashSet<>();

    public Category() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category(String description, String title) {
        this.description = description;
        this.title = title;
    }
}
