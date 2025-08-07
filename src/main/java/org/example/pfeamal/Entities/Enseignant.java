package org.example.pfeamal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "enseignant")
public class Enseignant extends User{

    private String Matricule;

    private String nom_prenom_ensignant;

    private String cv;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;


    @PrePersist
    public void setRoleValue() {
        this.role = Role.ENSEIGNANT;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getNom_prenom_ensignant() {
        return nom_prenom_ensignant;
    }

    public void setNom_prenom_ensignant(String nom_prenom_ensignant) {
        this.nom_prenom_ensignant = nom_prenom_ensignant;
    }

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Quiz> quizList;

    @JsonIgnore
    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
