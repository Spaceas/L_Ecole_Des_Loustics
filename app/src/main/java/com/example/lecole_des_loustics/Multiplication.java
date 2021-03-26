package com.example.lecole_des_loustics;

public class Multiplication {
    //Classe qui ne s'occupe que des données, ne modifie pas l'affichage graphique

    private int operande1;
    private int operande2;
    private int resultat;

    Multiplication(int op1, int op2){
        operande1 = op1;
        operande2 = op2;
    }

    //Getters
    public int getOperande1() {
        return operande1;
    }

    public int getOperande2() {
        return operande2;
    }

    public int getResultat() {
        return resultat;
    }

    //Setters
    public void setOperande1(int operande1) {
        this.operande1 = operande1;
    }

    public void setOperande2(int operande2) {
        this.operande2 = operande2;
    }

    //Méthode qui renvoie vrai si le resultat donné est le bon
    public boolean resultatOK(){
        return resultat == (operande1 * operande2);

    }



}
