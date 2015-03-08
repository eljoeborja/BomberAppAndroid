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
 * Created by gurzaf on 1/6/15.
 */
public class VehiculoListAdapter extends ArrayAdapter<Vehiculo> {
    public VehiculoListAdapter(Context context, List<Vehiculo> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Vehiculo vehiculo = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.vehiculo_item_layout, parent, false);
        }
        TextView labelPlaca = (TextView) convertView.findViewById(R.id.labelPlaca);
        TextView labelModelo = (TextView) convertView.findViewById(R.id.labelModelo);
        if(vehiculo!=null){
            if(vehiculo.getVehPlaca()!=null){
                labelPlaca.setText(vehiculo.getVehPlaca());
            }
            if(vehiculo.getVehModelo()!=null){
                labelModelo.setText(vehiculo.getVehModelo());
            }
        }
        return convertView;
    }
}
