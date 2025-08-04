package org.example.pfeamal.payload.request;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

public class SignupRequest {
    //ajout de mej pour les indice affichaj fi intelij console
    @NotBlank(message = "Le champ ne doit pas être vide")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Le champ doit contenir uniquement des lettres")
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @JsonDeserialize
    private String firstname;
    @JsonDeserialize
    private String lastname ;

    @JsonDeserialize
    private String phone ;
    @JsonDeserialize
    private String cin ;



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }



    private String fonction ;

    private String role;

    private String address;
//ajout des propriité de provider dans le request
  private String matricule;
    private String company;
    private String service;
    // fin d'jout de prop provider dan srequest

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


    //ajout photo pour test
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    


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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
