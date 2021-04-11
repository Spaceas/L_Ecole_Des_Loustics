package com.example.lecole_des_loustics;

import android.app.Application;

public class MyApplication extends Application {

    private String nom;
    private String prenom;
    private int scoreMult;
    private int scoreAdd;

    //Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getScoreAdd() { return scoreAdd; }

    public int getScoreMult() { return scoreMult; }

    //Setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setScoreAdd(int scoreAdd) { this.scoreAdd = scoreAdd; }

    public void setScoreMult(int scoreMult) { this.scoreMult = scoreMult; }
}
