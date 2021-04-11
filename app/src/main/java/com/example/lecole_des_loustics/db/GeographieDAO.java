package com.example.lecole_des_loustics.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GeographieDAO {

    @Query("SELECT Intitule FROM questgeo")
    List<String> getIntitule();
    
    @Query("SELECT BonneReponse FROM questgeo")
    List<String> getBonneRep();

    @Query("SELECT * FROM questgeo")
    List<QuestGeo> getAll();

    @Insert
    void insert(QuestGeo questionGeo);

}