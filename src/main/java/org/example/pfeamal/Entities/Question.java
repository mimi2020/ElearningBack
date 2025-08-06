package org.example.pfeamal.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id @GeneratedValue
    private Long id;
    private String content;

    @ManyToOne
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Choice> choices;

    private int correctAnswerIndex; // index de la bonne réponse
}
