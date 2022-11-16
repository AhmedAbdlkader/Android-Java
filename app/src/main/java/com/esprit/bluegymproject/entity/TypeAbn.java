package com.esprit.bluegymproject.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "typeabn")
public class TypeAbn {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String nom;
    private String Description;
    private int Price;
    private int age;

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return Description;
    }

    public int getPrice() {
        return Price;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TypeAbn{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", age=" + age +
                '}';
    }

    public TypeAbn() {
    }

    public TypeAbn(String nom, String description, int price, int age) {
        this.nom = nom;
        Description = description;
        Price = price;
        this.age = age;
    }

    public TypeAbn(long id, String nom, String description, int price, int age) {
        this.id = id;
        this.nom = nom;
        Description = description;
        Price = price;
        this.age = age;
    }
}
