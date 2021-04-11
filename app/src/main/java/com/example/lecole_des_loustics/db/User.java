package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Nom")
    private String nom;

    @ColumnInfo(name = "Prenom")
    private String prenom;


    /*
     * Getters and Setters
     * */
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nomUser) {
        this.nom = nomUser;
    }

    public void setPrenom(String prenomUser) {
        this.prenom = prenomUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int Newid) {
        this.id = Newid;
    }

}
