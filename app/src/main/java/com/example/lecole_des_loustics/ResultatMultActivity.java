package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ResultatMultActivity extends AppCompatActivity{

    public static final String SCOREMULT = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_multiplication);

        String score = getIntent().getStringExtra(SCOREMULT);

        TextView nbError = findViewById(R.id.nbErreurs);
        nbError.setText("Votre score est de " + score + "/10");
    }

    public void changerTable(View view) {
        // Intent Creation
        Intent intent = new Intent(this, MultActivity.class);

        // Adding flags
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Starting intent
        startActivity(intent);
    }

    public void RetourMenuPrincipal(View view) {
        // Intent Creation
        Intent intent = new Intent(this, MainActivity.class);

        // Adding flags
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Starting intent
        startActivity(intent);
    }

}
