package org.example.pfeamal.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "eleve")
public class Eleve extends User {
@NotNull
    private String nom_prenom_eleve;
    private String nom_prenom_parent;

    private Date date_naissance;



    @Enumerated(EnumType.STRING)
    private Situation_Eleve situation;

    @Enumerated(EnumType.STRING)
    private Niveau_SCOLAIRE niveau;


    @PrePersist
    public void setRoleValue() {
        this.role = Role.ELEVE;
    }

    public Situation_Eleve getSituation() {
        return situation;
    }

    public void setSituation(Situation_Eleve situation) {
        this.situation = situation;
    }

    public String getNom_prenom_parent() {
        return nom_prenom_parent;
    }

    public void setNom_prenom_parent(String nom_prenom_parent) {
        this.nom_prenom_parent = nom_prenom_parent;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Niveau_SCOLAIRE getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau_SCOLAIRE niveau) {
        this.niveau = niveau;
    }

    public String getNom_prenom_eleve() {
        return nom_prenom_eleve;
    }

    public void setNom_prenom_eleve(String nom_prenom_eleve) {
        this.nom_prenom_eleve = nom_prenom_eleve;
    }
}
