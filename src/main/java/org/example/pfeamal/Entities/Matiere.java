package org.example.pfeamal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Matiere")
public class Matiere {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Matiere() {
    }

    public Matiere(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "categorie")
    private List<Cours> formations;

    @JsonIgnore
    public List<Cours> getFormations() {
        return formations;
    }


    public void setFormations(List<Cours> formations) {
        this.formations = formations;
    }
}
