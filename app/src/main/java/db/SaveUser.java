package db;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lecole_des_loustics.R;

import db.DatabaseClient;
import db.User;

public class SaveUser extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    // VIEW
    private EditText editTextUserView;
    private EditText editTextDescriptionView;
    private EditText editTextFinishByView;
    private Button saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_add_task);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextUserView = findViewById(R.id.editTextUser);
        saveView = findViewById(R.id.bouton_save);

        // Associer un événement au bouton save
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {

        // Récupérer les informations contenues dans les vues
        final String user_nom = editTextUserView.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (user_nom.isEmpty()) {
            editTextUserView.setError("Entrez votre nom");
            editTextUserView.requestFocus();
            return;
        }


        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class Save extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setNom(user_nom);

                // adding to database
                mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        Save st = new Save();
        st.execute();
    }

}
