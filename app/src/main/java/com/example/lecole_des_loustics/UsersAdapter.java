package com.example.lecole_des_loustics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lecole_des_loustics.db.User;

import java.util.List;

public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(Context mCtx, List<User> userList) {
        super(mCtx, R.layout.template_user, userList);
    }

    /**
     * Remplit une ligne de la listView avec les informations de l'utilisateur associée
     *
     * @param id
     * @param convertView
     * @param parent
     * @return
     */

    @Override
    public View getView(int id, View convertView, ViewGroup parent) {

        // Récupération de l'utilisateur
        final User user = getItem(id);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewNom = (TextView) rowView.findViewById(R.id.textViewNom);
        TextView textViewPrenom = (TextView) rowView.findViewById(R.id.textViewPrenom);

        //
        textViewNom.setText(user.getNom());
        textViewPrenom.setText(user.getPrenom());

        //
        return rowView;
    }

}
