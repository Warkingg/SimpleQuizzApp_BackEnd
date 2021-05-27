package com.example.quizztest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String response1;

    private String response2;

    private String response3;

    private String response4;

    private String correct;

    @ManyToOne
    private Level level;

    public Question() {
    }

    public Question(Long id, String question, String response1, String response2, String response3, String response4, String correct, Level level) {
        this.id = id;
        this.question = question;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
        this.correct = correct;
        this.level = level;
    }
}
