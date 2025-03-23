package com.practise.quizapp.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Integer id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "JQuiz", // This will be the actual join table name
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;


    public Quiz(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }
    public Quiz(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
