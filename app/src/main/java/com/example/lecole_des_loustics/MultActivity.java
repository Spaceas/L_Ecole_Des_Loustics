package com.example.lecole_des_loustics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class MultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_mult);
        NumberPicker nb = findViewById(R.id.tableMult);
        nb.setMaxValue(12);
        nb.setMinValue(0);

    }

    public void choixTable(View view){
        NumberPicker nb = findViewById(R.id.tableMult);
        int table = nb.getValue();

        Intent intent = new Intent(this, TableMult.class);
        intent.putExtra(TableMult.VAL_KEY, table);

        startActivity(intent);
    }
}
