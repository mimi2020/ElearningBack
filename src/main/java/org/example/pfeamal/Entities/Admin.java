package org.example.pfeamal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin extends User{


    private String nom_prenom_admin;
    @PrePersist
    public void setRoleValue() {
        this.role = Role.ADMIN;
    }

    public String getNom_prenom_admin() {
        return nom_prenom_admin;
    }

    public void setNom_prenom_admin(String nom_prenom_admin) {
        this.nom_prenom_admin = nom_prenom_admin;
    }
}
