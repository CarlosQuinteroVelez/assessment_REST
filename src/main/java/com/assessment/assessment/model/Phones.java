package com.assessment.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name =  "\"phones\"")
public class Phones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String citycode;
    private String countrycode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Phones(String number, String citicode, String countrycode ) {
        this.number = number;
        this.citycode = citicode;
        this.countrycode = countrycode;

    }
    public Phones(String number, String citycode, String countrycode, User user) {
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
        this.user = user;
    }


    public Phones() {

    }

    public Phones(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", countrycode='" + countrycode + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
