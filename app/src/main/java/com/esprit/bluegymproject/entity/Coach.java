package com.esprit.bluegymproject.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "coachs")
public class Coach {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nom;

    private String prenom;

    private String speciality;

    private int experience;

    private int age;

    public Coach(long id, String nom, String prenom, String speciality, int experience, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.speciality = speciality;
        this.experience = experience;
        this.age = age;
    }

    public Coach() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience=" + experience +
                ", age=" + age +
                '}';
    }
}
