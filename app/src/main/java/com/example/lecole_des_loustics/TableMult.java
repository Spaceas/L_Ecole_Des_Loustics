package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TableMult extends AppCompatActivity {
    //Ici on ne s'occupe que des modifications graphiques !
    //Il faut bien sûr créer la table et ses multiplications mais les calculs ne seront pas fait ici

    public static final String VAL_KEY = "val_key";
    private static int numTable = 0;

    //Cf classe TableData et Multiplication
    private ArrayList<Multiplication> mult = new ArrayList<>();
    private TableData tableau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_mult);

        numTable = getIntent().getIntExtra(VAL_KEY, 0);

        //On créer toutes les multiplications
        for (int i = 0; i < tableau.getTaille(); i++) {
            mult.add(new Multiplication(numTable, i + 1));
        }


        //On créer la table de multiplication
        tableau = new TableData(mult);
        modifTable();


    }

    public void modifTable() {
        LinearLayout linear = (LinearLayout) findViewById(R.id.multBloc);

        for (Multiplication m : tableau.getTable()) {
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            TextView calcul = (TextView) linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(m.getOperande1() + " x " + m.getOperande2() + " = ");
            linear.addView(linearTMP);
        }
    }

    public void afficheResultat(View view) {
        int score = 0;
        for (Multiplication m : tableau.getTable()) {
            if (m.resultatOK()) {
                score++;
            }
        }

        // Intent creation
        Intent intent = new Intent(this, ResultatMultActivity.class);

        // Adding value
        intent.putExtra(ResultatMultActivity.SCOREMULT, Integer.toString(score));

        // Starting activity
        startActivity(intent);

    }
}