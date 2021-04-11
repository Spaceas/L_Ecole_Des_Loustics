package com.example.lecole_des_loustics.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class QuestGeo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Intitule")
    private String intitule;

    @ColumnInfo(name = "BonneReponse")
    private String bonneRep;

    /*
     * Getters and Setters
     * */
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intQuestion ) {
        this.intitule = intQuestion;
    }

    public String getBonneRep() { return bonneRep; }

    public int getId() {
        return id;
    }

    public void setId(int Newid) {
        this.id = Newid;
    }

    public void setBonneRep(String bonneRep) { this.bonneRep = bonneRep; }
}
