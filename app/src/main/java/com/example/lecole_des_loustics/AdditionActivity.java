package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lecole_des_loustics.modele.Addition;


public class AdditionActivity extends AppCompatActivity {

    public ArrayList<Addition> additions = new ArrayList<>();
    public int additionActuelle;
    LinearLayout linear;
    EditText result;
    TextView labelErreur;
    Button boutonSuivant;
    Button boutonPrecedent;
    Button boutonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        labelErreur = (TextView) findViewById(R.id.labelErreur);

        for(int i = 0; i < 10; i++){
            int nombreAleatoire1 = 1 + (int)(Math.random() * ((10 - 1) + 1));
            int nombreAleatoire2 = 1 + (int)(Math.random() * ((10 - 1) + 1));
            Addition addition = new Addition(nombreAleatoire1, nombreAleatoire2);
            additions.add(addition);
        }

        additionActuelle = 0;
        linear = findViewById(R.id.results);
        boutonSuivant = (Button) findViewById(R.id.boutonSuivant);
        boutonPrecedent = (Button) findViewById(R.id.boutonPrecedent);
        boutonValider = (Button) findViewById(R.id.boutonValider);

        boutonValider.setVisibility(View.GONE);
        boutonPrecedent.setVisibility(View.GONE);
        // Temp line creation
        LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul_addition, null);

        TextView calcul = (TextView) linearTMP.findViewById(R.id.template_calcul);
        calcul.setText( additions.get(additionActuelle).getOperande1() + " + " + additions.get(additionActuelle).getOperande2() + " = ");

        result = linearTMP.findViewById(R.id.template_result);

        linear.addView(linearTMP);
    }

    public void Valider(View view){

        if (result.getText().toString() != "") {
            int score = 1;
            for (Addition addition : additions) {
                if(addition.resultatOK()){
                    score = score+1;
                }

            }

            // Intent creation
            Intent intent = new Intent(this, ResultatAdditionActivity.class);

            // Adding value
            intent.putExtra(ResultatAdditionActivity.SCORE, Integer.toString(score));

            // Starting activity
            startActivity(intent);
        }
    }

    public void Suivant(View view){
        try{
            additions.get(additionActuelle).setResultat(Integer.parseInt(result.getText().toString()));

            additionActuelle += 1;

            linear.removeAllViews();
            // Temp line creation
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul_addition, null);

            TextView calcul = linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(additions.get(additionActuelle).getOperande1() + " + " + additions.get(additionActuelle).getOperande2() + " = ");

            result = linearTMP.findViewById(R.id.template_result);
            if (additions.get(additionActuelle).getResultat() != 0){
                result.setText(Integer.toString(additions.get(additionActuelle).getResultat()));
            }
            linear.addView(linearTMP);

            if (additionActuelle == 9){
                boutonSuivant.setVisibility(View.GONE);
                boutonValider.setVisibility(View.VISIBLE);
            } else if (additionActuelle == 1){
                boutonPrecedent.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            labelErreur.setText("Entre un chiffre ou un nombre !");
        }

    }

    public void Precedent(View view){
        if (additionActuelle == 1) {
            boutonPrecedent.setVisibility(View.GONE);
        } else if(additionActuelle == 9){
            boutonValider.setVisibility(View.GONE);
            boutonSuivant.setVisibility(View.VISIBLE);
        } else if(additionActuelle == 9){
            additions.get(additionActuelle).setResultat(Integer.parseInt(result.getText().toString()));
        }
        if (additionActuelle != 0) {
            additionActuelle -= 1;

            linear.removeAllViews();
            // Temp line creation
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul_addition, null);

            TextView calcul = linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(additions.get(additionActuelle).getOperande1() + " + " + additions.get(additionActuelle).getOperande2() + " = ");

            result = linearTMP.findViewById(R.id.template_result);
            result.setText(Integer.toString(additions.get(additionActuelle).getResultat()));

            linear.addView(linearTMP);
        }
    }



}
