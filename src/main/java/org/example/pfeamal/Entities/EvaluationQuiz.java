package org.example.pfeamal.Entities;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class EvaluationQuiz {


        @Id @GeneratedValue
        private Long id;

        @ManyToOne
        private Quiz quiz;

        @ManyToOne
        private User utilisateur;

        private double note;

        @ElementCollection
        private Map<Long, Integer> reponses; // questionId -> index choisi
    }
