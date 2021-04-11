package com.example.lecole_des_loustics.modele;

import java.util.ArrayList;

public class CultureGenerale {

    private ArrayList<String> intitule;
    private ArrayList<String> bonnesReponses;
    private ArrayList<String> mauvaisesReponses ;

    CultureGenerale(){
        intitule = new ArrayList<>();
        bonnesReponses = new ArrayList<>();
        mauvaisesReponses = new ArrayList<>();
    }

    public ArrayList<String> getIntitule() {
        return intitule;
    }

    public ArrayList<String> getBonnesReponses() {
        return bonnesReponses;
    }

    public ArrayList<String> getMauvaisesReponses() {
        return mauvaisesReponses;
    }




}
