package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.lecole_des_loustics.ExoMathsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exoMaths(View view){
        Intent intent = new Intent(this, ExoMathsActivity.class);
        startActivity(intent);
    }
}