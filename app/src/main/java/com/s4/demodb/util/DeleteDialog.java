package com.s4.demodb.util;

import android.app.Activity;
import android.app.AlertDialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import com.s4.demodb.MainActivity;
import com.s4.demodb.db.util.Usuario;

public class DeleteDialog extends DialogFragment {

    private Usuario usuario;

    private static final String TAG = "DeleteDialog";
    private ActivityNavigationListener listener;

    public DeleteDialog(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(getArguments()!=null){

            if(getArguments().containsKey(MainActivity.KEY_USUARIO)){
                usuario = (Usuario) getArguments().getSerializable(MainActivity.KEY_USUARIO);
                Log.i(TAG,"Usuario: ".concat(usuario.toString()));
            }

        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Confirma que desea eliminar el usuario "+usuario.getName()+"?")
                .setTitle("Confirmacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(DeleteDialog.this);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (ActivityNavigationListener) activity;
        }catch (Exception e){
            throw new ClassCastException(activity.toString()
                    + " must implement ActivityNavigationListener");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}