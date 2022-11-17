package com.esprit.bluegymproject.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prod")
public class Produits {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "price")
    private String price;
    @ColumnInfo(name = "marque")
    private String marque;
    @ColumnInfo(name = "description")
    private String description;

    public Produits() {
    }

    public Produits(int uid, String name, String price, String marque, String description) {
        this.uid = uid;
        this.name = name;
        this.price = price;
        this.marque = marque;
        this.description = description;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produits{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", marque='" + marque + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
