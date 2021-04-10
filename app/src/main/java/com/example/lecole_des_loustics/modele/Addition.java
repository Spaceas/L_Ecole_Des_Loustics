package com.example.lecole_des_loustics.modele;

public class Addition {

    //Attributs
    private int operande1;
    private int operande2;
    private int resultat;

    //Constructeur
    public Addition(int op1, int op2){
        this.operande1 = op1;
        this.operande2 = op2;
        this.resultat = 0;
    }

    //Getters
    public int getOperande1() { return this.operande1; }
    public int getOperande2() { return this.operande2; }
    public int getResultat() { return this.resultat; }

    //Setters
    public void setResultat(int result){
        this.resultat = result;
    }

    //Méthode qui renvoie vrai si le resultat donné est le bon
    public boolean resultatOK(){
        return resultat == (operande1 + operande2);
    }

}
