package com.assessment.assessment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true)

    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Phones> phones;

    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;

    private String token;
    private boolean isActive;

    public User() {

    }



    @JsonCreator
    public User(@JsonProperty("name") String name,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("phones") List<Phones> phones) {
        this.name = name;
        this.email = email;
        this.password=password;
        this.phones = phones != null ? phones : new ArrayList<>();
    }//*/

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordField=" + password +
                ", phones=" + phones +
                '}';
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
