package com.s4.demodb.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import com.s4.demodb.ListVehiculoActivity;
import com.s4.demodb.db.util.Vehiculo;

public class DeleteDialogVehiculo extends DialogFragment {

    private Vehiculo vehiculo;

    private static final String TAG = "DeleteDialog";
    private ActivityNavigationListenerVehiculo listener;

    public DeleteDialogVehiculo(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(getArguments()!=null){

            if(getArguments().containsKey(ListVehiculoActivity.KEY_USUARIO)){
                vehiculo = (Vehiculo) getArguments().getSerializable(ListVehiculoActivity.KEY_USUARIO);
                Log.i(TAG,"vehiculo: ".concat(vehiculo.toString()));
            }

        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Confirma que desea eliminar el vehiculo "+vehiculo.getPlaca()+"?")
                .setTitle("Confirmacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(DeleteDialogVehiculo.this);
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
            listener = (ActivityNavigationListenerVehiculo) activity;
        }catch (Exception e){
            throw new ClassCastException(activity.toString()
                    + " must implement ActivityNavigationListener");
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}