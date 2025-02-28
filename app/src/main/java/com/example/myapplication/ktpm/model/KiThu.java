package com.example.myapplication.ktpm.model;

import java.time.LocalDate;

public class KiThu {
    private String name, password, national,id;

    private LocalDate dateOfBirth;
    private int elo;
    private String sex;
    private String email;
    private String phone;

    public KiThu(String name, String password, String national, LocalDate dateOfBirth, int elo,
                 String sex, String email, String phone) {
        this.name = name;
        this.password = password;
        this.national = national;
        this.dateOfBirth = dateOfBirth;
        this.elo = elo;
        this.sex = sex;
        this.email = email;
        this.phone = phone;

    }
    public KiThu(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
