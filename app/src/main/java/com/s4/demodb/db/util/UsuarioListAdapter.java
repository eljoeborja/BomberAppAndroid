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
public class UsuarioListAdapter extends ArrayAdapter<Usuario> {
    public UsuarioListAdapter(Context context, List<Usuario> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Usuario usuario = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.usuario_item_layout, parent, false);
        }

        TextView labelCodigo = (TextView) convertView.findViewById(R.id.labelCodigo);
        TextView labelNombre = (TextView) convertView.findViewById(R.id.labelNombre);

        if(usuario!=null){
            if(usuario.getCode()!=null){
                labelCodigo.setText(usuario.getCode().toString());
            }

            if(usuario.getName()!=null){
                labelNombre.setText(usuario.getName());
            }
        }


        return convertView;

    }
}
