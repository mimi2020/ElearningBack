package org.example.pfeamal.Entities;

import jakarta.persistence.*;

@Entity
public class Choice {
    @Id @GeneratedValue
    private Long id;
    private String text;

    @ManyToOne
    private Question question;

    private int index; // 0, 1, 2, 3...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

