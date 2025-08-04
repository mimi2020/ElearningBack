package org.example.pfeamal.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valeur ;
    private String commentaire ;

    @Enumerated(EnumType.STRING)
    private Utilite utilite ;
    private Integer note;

//    @Enumerated(EnumType.STRING)
//    private TypeEvaluation type;
//
//    public TypeEvaluation getType() {
//        return type;
//    }
//
//    public void setType(TypeEvaluation type) {
//        this.type = type;
//    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Utilite getUtilite() {
        return utilite;
    }

    public void setUtilite(Utilite utilite) {
        this.utilite = utilite;
    }

    public Evaluation() {
    }

//    @ManyToOne
//    @JoinColumn(name = "idemploye")
//    private Employe employeEva;
//
//
    @ManyToOne
    @JoinColumn(name = "idformation")
    private Formation formationEva;
//
//
//    public Employe getEmployeEva() {
//        return employeEva;
//    }
//
//    public void setEmployeEva(Employe employeEva) {
//        this.employeEva = employeEva;
//    }
//
    public Formation getFormationEva() {
        return formationEva;
    }

    public void setFormationEva(Formation formationEva) {
        this.formationEva = formationEva;
    }

}
