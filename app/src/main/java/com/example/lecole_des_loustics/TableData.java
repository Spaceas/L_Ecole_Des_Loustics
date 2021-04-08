package com.example.lecole_des_loustics;

import com.example.lecole_des_loustics.Multiplication;

import java.util.ArrayList;

public class TableData {
    //Classe qui ne s'occupe que des données, ne fais aucune modifications graphique

    private static int taille = 10;
    private ArrayList<Multiplication> table = new ArrayList<>();

    TableData(ArrayList<Multiplication> tb ){
        //Je ne suis pas sûre de ça
        table = tb;
    }

    //Getters
    public ArrayList<Multiplication> getTable() {
        return table;
    }

    public static int getTaille() {
        return taille;
    }


    //Méthode qui compte le nombre d'erreurs dans une table
    //Pas sûre de ce que j'ai écris
    public int nbErreurs(){
        int err = 0;
        for(int i = 0; i < taille; i++){
            if(table.get(i).resultatOK() ){
                err++;
            }
        }
        return err;
    }
}
