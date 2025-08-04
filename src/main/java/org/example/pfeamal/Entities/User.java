package org.example.pfeamal.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Entity
        @Table(name = "userEntity",uniqueConstraints = @UniqueConstraint(columnNames = "email"))

@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Email

    @Column(nullable = false, unique = true)
    private String email ;
    private String  password ;
    private String  address ;
    private String  phone ;

    private  String  photo ;



    @Enumerated(EnumType.STRING)
    protected Role role;

    private boolean confirm=false;

    private  String  username;





    public String getPasswordResetToken() {
        return passwordResetToken;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    private String passwordResetToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }




    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }



    public User() {
    }

   }
