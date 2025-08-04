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
        this.heureAjout = LocalTime.now(); // stocke l'heure automatiquement
    }
}
