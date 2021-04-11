package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lecole_des_loustics.modele.CultureGenerale;


public class GeographieActivity extends AppCompatActivity {

    public ArrayList<String> intitule;
    public ArrayList<String> bonneRep = new ArrayList<>();
    public ArrayList<String> mauvaiseRep = new ArrayList<>();
    public ArrayList<String> reponsesProposees = new ArrayList<>();

    public int questionActuelle;
    int score = 0;
    LinearLayout linear;
    EditText result;
    RadioGroup groupeRadio;

    TextView labelErreur;
    Button boutonSuivant;
    Button boutonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        labelErreur = (TextView) findViewById(R.id.labelErreur);
        questionActuelle = 0;
        groupeRadio = findViewById(R.id.boutonGroupe);

        //Initialisation des ArrayList
        intitule = new ArrayList(){{
            add("De quel pays est originaire le youtubeur Amixem ?");
            add("Dans quel pays se trouve la statue de la liberté ?");
            add("Quel est le plus grand pays du monde ?");
            add("De quel pays proviennent les fajitas ?");
            add("De quel pays Eddy-Malou est-il l'homme le plus intelligent ?");
            add("De quel pays provient Excalibur ?");
            add("Quel est le seul pays dans lequel on peut voir un ornithorynque");
            add("De quel pays est originaire le Sphinx ?");
            add("C'est normal en ?");
            add("Dans quel pays trouve-t-on le plus grand fleuve du monde ?");
        }};

        bonneRep = new ArrayList(){{
            add(" France");
            add(" Etats Unis");
            add(" Russie");
            add(" Mexique");
            add(" Republique démocratique du Congo");
            add(" Angleterre");
            add(" Australie");
            add(" Egypte");
            add(" Russie");
            add(" Brésil");
        }};

        mauvaiseRep = new ArrayList(){{
            add(" Ghana");
            add(" Chine");
            add(" Allemagne");
            add(" Guatemala");
            add(" Japon");
            add(" Luxembourg");
            add(" Croatie");
            add(" Bolivie");
            add(" Finlande");
            add(" Canada");
            add(" Côte d'Ivoire");
            add(" Montenegro");
            add(" Ukraine");
            add(" Buthan");
            add(" Inde");
            add(" Mozambique");
            add(" Burkina Faso");
            add(" Cuba");
            add(" Panama");
            add(" Haiti");
            add(" Jordanie");
            add(" Israel");
            add(" Indonésie");
            add(" Angola");
            add(" Népal");
            add(" Chypre");
            add(" Soudan");
            add(" Algérie");
            add(" Géorgie");
            add(" Turkménistan");
            add(" Paraguay");
            add(" Malaisie");
            add(" Moldavie");
        }};
        Collections.shuffle(mauvaiseRep);

        reponsesProposees.add(bonneRep.get(questionActuelle));
        reponsesProposees.add(mauvaiseRep.get(0));
        reponsesProposees.add(mauvaiseRep.get(1));
        Collections.shuffle(reponsesProposees);


        linear = findViewById(R.id.results);
        boutonSuivant = (Button) findViewById(R.id.boutonSuivant);
        boutonValider = (Button) findViewById(R.id.boutonValider);

        boutonValider.setVisibility(View.GONE);
        // Temp line creation
        LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_reponses_multiples, null);

        TextView question = (TextView) linearTMP.findViewById(R.id.template_question);
        question.setText(intitule.get(questionActuelle));

        RadioButton radio1 = (RadioButton) linearTMP.findViewById(R.id.radioButton1);
        radio1.setText(reponsesProposees.get(0));

        RadioButton radio2 = (RadioButton) linearTMP.findViewById(R.id.radioButton2);
        radio2.setText(reponsesProposees.get(1));

        RadioButton radio3 = (RadioButton) linearTMP.findViewById(R.id.radioButton3);
        radio3.setText(reponsesProposees.get(2));

        linear.addView(linearTMP);
    }

    public void Valider(View view){


            // Intent creation
            Intent intent = new Intent(this, ResultatGeoActivity.class);

            // Adding value
            intent.putExtra(ResultatAdditionActivity.SCORE, Integer.toString(score));

            // Starting activity
            startActivity(intent);
        }


    public void Suivant(View view){


            groupeRadio = findViewById(R.id.boutonGroupe);
            LinearLayout tpmp = (LinearLayout) findViewById(R.id.results);
            RadioButton radio = (RadioButton) tpmp.findViewById(groupeRadio.getCheckedRadioButtonId());

            if(radio.getText().equals(bonneRep.get(questionActuelle))){
                score++;
            }

            questionActuelle = questionActuelle+1;

            Collections.shuffle(mauvaiseRep);

            reponsesProposees.clear();
            reponsesProposees.add(bonneRep.get(questionActuelle));
            reponsesProposees.add(mauvaiseRep.get(0));
            reponsesProposees.add(mauvaiseRep.get(1));

            Collections.shuffle(reponsesProposees);

            linear.removeAllViews();
            // Temp line creation
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_reponses_multiples, null);

            TextView question = (TextView) linearTMP.findViewById(R.id.template_question);
            question.setText(intitule.get(questionActuelle));

            RadioButton radio1 = (RadioButton) linearTMP.findViewById(R.id.radioButton1);
            radio1.setText(reponsesProposees.get(0));

            RadioButton radio2 = (RadioButton) linearTMP.findViewById(R.id.radioButton2);
            radio2.setText(reponsesProposees.get(1));

            RadioButton radio3 = (RadioButton) linearTMP.findViewById(R.id.radioButton3);
            radio3.setText(reponsesProposees.get(2));

            linear.addView(linearTMP);

            if (questionActuelle == 9){
                boutonSuivant.setVisibility(View.GONE);
                boutonValider.setVisibility(View.VISIBLE);
            }


    }


}
