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
}

