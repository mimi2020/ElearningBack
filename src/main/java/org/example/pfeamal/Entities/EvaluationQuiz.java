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

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Quiz getQuiz() {
                return quiz;
        }

        public void setQuiz(Quiz quiz) {
                this.quiz = quiz;
        }

        public User getUtilisateur() {
                return utilisateur;
        }

        public void setUtilisateur(User utilisateur) {
                this.utilisateur = utilisateur;
        }

        public double getNote() {
                return note;
        }

        public void setNote(double note) {
                this.note = note;
        }

        public Map<Long, Integer> getReponses() {
                return reponses;
        }

        public void setReponses(Map<Long, Integer> reponses) {
                this.reponses = reponses;
        }
}
