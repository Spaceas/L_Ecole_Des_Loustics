package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.lecole_des_loustics.MainActivity;
import com.example.lecole_des_loustics.MultActivity;
import com.example.lecole_des_loustics.AdditionActivity;



public class ExoMathsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_exo_activity);

    }

    public void TableMulti(View view) {
        // Intent Creation
        Intent MultiplicationIntent = new Intent(this, MultActivity.class);

        // Starting intent
        startActivity(MultiplicationIntent);
    }

    public void ExoAddition(View view){
        //Intent Creation
        Intent AdditionIntent = new Intent(this, AdditionActivity.class);

        //Starting intent
        startActivity(AdditionIntent);
    }

    public void ExoGeo(View view){
        Intent Geointent = new Intent(this, GeographieActivity.class );

        startActivity(Geointent);
    }

    public void RetourMenu(View view) {
        // Intent Creation
        Intent RetourIntent = new Intent(this, MainActivity.class);

        // Adding flags
        RetourIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Starting intent
        startActivity(RetourIntent);
    }
}

