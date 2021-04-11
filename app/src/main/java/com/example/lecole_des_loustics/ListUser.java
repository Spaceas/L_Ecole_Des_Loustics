package com.example.lecole_des_loustics;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lecole_des_loustics.MyApplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.lecole_des_loustics.db.DatabaseClient;
import com.example.lecole_des_loustics.db.User;

import java.util.ArrayList;
import java.util.List;

public class ListUser extends AppCompatActivity {

    //Data
    private DatabaseClient mDb;
    private UsersAdapter adapter;

    //View
    private ListView listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUser = findViewById(R.id.listUser);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        // EXEMPLE : Ajouter un événement click à la listView
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);


                // Message
                Toast.makeText(ListUser.this, "Click : " + user.getNom(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getUsers(){
    class GetUsers extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {
            List<User> userList = mDb.getAppDatabase()
                    .userDao()
                    .getAll();
            return userList;
        }

        @Override
        protected void onPostExecute(List<User> user) {
            super.onPostExecute(user);

            // Mettre à jour l'adapter avec la liste de taches
            adapter.clear();
            adapter.addAll(user);

            // Now, notify the adapter of the change in source
            adapter.notifyDataSetChanged();

        }
    }
        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        GetUsers gu = new GetUsers();
        gu.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des utilisateurs
        getUsers();

    }



}
