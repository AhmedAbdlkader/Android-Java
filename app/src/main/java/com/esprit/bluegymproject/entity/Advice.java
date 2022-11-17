package com.esprit.bluegymproject.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "advice")
public class Advice {


    @PrimaryKey(autoGenerate = true)
    private long id;

    private String message;

    public Advice(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Advice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
