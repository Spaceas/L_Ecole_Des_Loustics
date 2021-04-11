package com.example.lecole_des_loustics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lecole_des_loustics.db.QuestGeo;

import java.util.List;

public class GeoAdapter extends ArrayAdapter<QuestGeo> {

    public GeoAdapter(Context mCtx, List<QuestGeo> geoList) {
        super(mCtx, R.layout.template_geo, geoList);
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
        final QuestGeo geo = getItem(id);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_geo, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewNom = (TextView) rowView.findViewById(R.id.textViewIntitule);

        //
        textViewNom.setText(geo.getIntitule());

        //
        return rowView;
    }

}

