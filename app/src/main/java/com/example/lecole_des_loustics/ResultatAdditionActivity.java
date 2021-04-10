package com.example.lecole_des_loustics;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ResultatAdditionActivity extends AppCompatActivity {

    public static final String SCORE = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_addition);

        String score = getIntent().getStringExtra(SCORE);

        TextView nbError = findViewById(R.id.labelNbErreurs);
        nbError.setText("Votre score est de " + score + "/10");
    }

    public void ExoMathsSelect(View view) {
        // Intent Creation
        Intent intent = new Intent(this, ExoMathsActivity.class);

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

