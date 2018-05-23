package com.example.demo.model;

import javax.persistence.*;

@Entity
public class BonusInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Streetname;
    private String City;
    private String Country;

    @OneToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetname() {
        return Streetname;
    }

    public void setStreetname(String streetname) {
        Streetname = streetname;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
