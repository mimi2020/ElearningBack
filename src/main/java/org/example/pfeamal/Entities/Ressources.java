package org.example.pfeamal.Entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name="ressource")
public class Ressources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titreRes;

    private String typeRes;

    private String contenuRes; // Nom du fichier stocké ou chemin

    private LocalTime heureAjout;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    @PrePersist
    public void setHeureAjout() {
        this.heureAjout = LocalTime.now();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitreRes() {
        return titreRes;
    }

    public void setTitreRes(String titreRes) {
        this.titreRes = titreRes;
    }

    public String getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(String typeRes) {
        this.typeRes = typeRes;
    }

    public String getContenuRes() {
        return contenuRes;
    }

    public void setContenuRes(String contenuRes) {
        this.contenuRes = contenuRes;
    }

    public LocalTime getHeureAjout() {
        return heureAjout;
    }

    public void setHeureAjout(LocalTime heureAjout) {
        this.heureAjout = heureAjout;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
