package org.example.pfeamal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quiz() {
    }
}
