package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.lecole_des_loustics.ExoMathsActivity;
import com.example.lecole_des_loustics.db.SaveUser;

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

    public void creaUser(View view){
        Intent intent = new Intent(this, SaveUser.class);
        startActivity(intent);
    }

    public void listerUser(View view){
        Intent intent = new Intent(this, ListUser.class);
        startActivity(intent);
    }
}