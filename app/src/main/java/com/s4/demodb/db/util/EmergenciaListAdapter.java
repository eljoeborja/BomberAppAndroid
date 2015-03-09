package com.s4.demodb.db.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.s4.demodb.R;

import java.util.List;

/**
 * Created by eljoeborja on 23/02/15.
 */
public class EmergenciaListAdapter extends ArrayAdapter<Emergencia> {
    public EmergenciaListAdapter(Context context, List<Emergencia> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Emergencia emergencia = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.emergencia_item_layout, parent, false);
        }
        TextView labelHora = (TextView) convertView.findViewById(R.id.labelHora);
        TextView labelDireccion = (TextView) convertView.findViewById(R.id.labelDireccion);

        if(emergencia!=null){
            if(emergencia.getEmeId()!=null){
                labelHora.setText(emergencia.getEmeHora().toString());
            }
            if(emergencia.getEmeDireccion()!=null){
                labelDireccion.setText(emergencia.getEmeDireccion());
            }
        }
        return convertView;
    }
}
