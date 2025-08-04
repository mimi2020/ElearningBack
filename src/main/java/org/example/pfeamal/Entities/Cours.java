package org.example.pfeamal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formation")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;

    private String etat;


    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datedebut ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datefin;

    private Integer nbrhour;

    private Float Prix ;

    private String nomformateur ;


    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Ressources> ressources = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cours(Long id, String nom, String description, String etat, String type, Date datedebut, Date datefin, Integer nbrhour, Float prix, String nomformateur) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.etat = etat;
        this.type = type;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbrhour = nbrhour;
        Prix = prix;
        this.nomformateur = nomformateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Integer getNbrhour() {
        return nbrhour;
    }

    public void setNbrhour(Integer nbrhour) {
        this.nbrhour = nbrhour;
    }

    public Float getPrix() {
        return Prix;
    }

    public void setPrix(Float prix) {
        Prix = prix;
    }

    public String getNomformateur() {
        return nomformateur;
    }

    public void setNomformateur(String nomformateur) {
        this.nomformateur = nomformateur;
    }



    public Cours() {
    }

    @ManyToOne
    @JoinColumn(name = "categorieid")
    private Matiere categorie;

    public Matiere getCategorie() {
        return categorie;
    }

    public void setCategorie(Matiere categorie) {
        this.categorie = categorie;
    }

//    @OneToMany(mappedBy = "Formationins",cascade = CascadeType.ALL)
//    private List<Inscription> inscriptions;

    @OneToMany(mappedBy = "formationEva",cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @JsonIgnore
    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

//    @JsonIgnore
//    public List<Inscription> getInscriptions() {
//        return inscriptions;
//    }
//
//    public void setInscriptions(List<Inscription> inscriptions) {
//        this.inscriptions = inscriptions;
//    }

//    @ManyToOne
//    @JoinColumn(name = "idbudget")
//    private  Budget budget ;

    private Long creepar;
    private Date datecreation;

    public Long getCreepar() {
        return creepar;
    }

    public void setCreepar(Long creepar) {
        this.creepar = creepar;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }
}
