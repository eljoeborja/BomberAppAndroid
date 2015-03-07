package com.s4.demodb.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import com.s4.demodb.ListEmergenciaActivity;
import com.s4.demodb.db.util.Emergencia;

public class DeleteDialogEmergencia extends DialogFragment {

    private Emergencia emergencia;
    private static final String TAG = "DeleteDialog";
    private ActivityNavigationListenerEmergencia listener;

    public DeleteDialogEmergencia(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(getArguments()!=null){

            if(getArguments().containsKey(ListEmergenciaActivity.KEY_USUARIO)){
                emergencia = (Emergencia) getArguments().getSerializable(ListEmergenciaActivity.KEY_USUARIO);
                Log.i(TAG,"emergencia: ".concat(emergencia.toString()));
            }

        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Confirma que desea eliminar la emergencia "+emergencia.getHora()+" - "+emergencia.getDireccion()+"?")
                .setTitle("Confirmacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(DeleteDialogEmergencia.this);
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
            listener = (ActivityNavigationListenerEmergencia) activity;
        }catch (Exception e){
            throw new ClassCastException(activity.toString()
                    + " must implement ActivityNavigationListener");
        }
    }

    public Emergencia getEmergencia() {
        return emergencia;
    }
}