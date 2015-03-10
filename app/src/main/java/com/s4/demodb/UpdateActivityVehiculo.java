package com.s4.demodb;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.s4.demodb.db.UsuariosDBOpenHelper;
import com.s4.demodb.db.util.Vehiculo;
import com.s4.demodb.util.ActivityNavigationListener;


public class UpdateActivityVehiculo extends ActionBarActivity {

    private UsuariosDBOpenHelper dbOpenHelper;
    private static final String TAG = "UpdateActivityVehiculo";
    private Vehiculo vehiculo;
    private Integer codigoOriginal;

    private ActivityNavigationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vehiculo);

        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        if(getIntent().hasExtra(ListVehiculoActivity.KEY_USUARIO)){
            vehiculo = (Vehiculo) getIntent().getSerializableExtra(ListVehiculoActivity.KEY_USUARIO);
            codigoOriginal = vehiculo.getVehId();
            System.out.println("Codigo Original traido de bd = "+codigoOriginal);
        }else{
            setResult(Activity.RESULT_CANCELED);
            finish();
        }

        loadData();

        Button buttonInsert = (Button) findViewById(R.id.buttonInsertVehiculo);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertarRegistro();

            }
        });

    }

    private void loadData() {

        EditText campoClase = (EditText) findViewById(R.id.campoClase);
        EditText campoPlaca = (EditText) findViewById(R.id.campoPlaca);
        EditText campoModelo = (EditText) findViewById(R.id.campoModelo);
        EditText campoPropietario = (EditText) findViewById(R.id.campoPropietario);
        EditText campoSoat = (EditText) findViewById(R.id.campoSoat);
        EditText campoServicio = (EditText) findViewById(R.id.campoServicio);
        EditText campoMarca = (EditText) findViewById(R.id.campoMarca);
        EditText campoEmpresa = (EditText) findViewById(R.id.campoEmpresa);
        EditText campoConductor = (EditText) findViewById(R.id.campoConductor);
        EditText campoCompaniaSeguro = (EditText) findViewById(R.id.campoCompaniaSeguro);

        if(vehiculo.getVehClase()!=null)
            campoClase.setText(vehiculo.getVehClase());
        if(vehiculo.getVehPlaca()!=null)
            campoPlaca.setText(vehiculo.getVehPlaca());
        if(vehiculo.getVehModelo()!=null)
            campoModelo.setText(vehiculo.getVehModelo());
        if(vehiculo.getVehPropietario()!=null)
            campoPropietario.setText(vehiculo.getVehPropietario());
        if(vehiculo.getVehSoat()!=null)
            campoSoat.setText(vehiculo.getVehSoat());
        if(vehiculo.getVehServicio()!=null)
            campoServicio.setText(vehiculo.getVehServicio());
        if(vehiculo.getVehMarca()!=null)
            campoMarca.setText(vehiculo.getVehMarca());
        if(vehiculo.getVehEmpresa()!=null)
            campoEmpresa.setText(vehiculo.getVehEmpresa());
        if(vehiculo.getVehConductor()!=null)
            campoConductor.setText(vehiculo.getVehConductor());
        if(vehiculo.getVehCompaniaSeguro()!=null)
            campoCompaniaSeguro.setText(vehiculo.getVehCompaniaSeguro());

        setTitle(getTitle().toString().concat(" ").concat(vehiculo.getVehPlaca()));

    }

    private void insertarRegistro() {

        try {

            String clase = ((EditText)findViewById(R.id.campoClase)).getText().toString();
            String placa = ((EditText)findViewById(R.id.campoPlaca)).getText().toString();
            String modelo = ((EditText)findViewById(R.id.campoModelo)).getText().toString();
            String propietario = ((EditText)findViewById(R.id.campoPropietario)).getText().toString();
            String soat = ((EditText)findViewById(R.id.campoSoat)).getText().toString();
            String servicio = ((EditText)findViewById(R.id.campoServicio)).getText().toString();
            String marca = ((EditText)findViewById(R.id.campoMarca)).getText().toString();
            String empresa = ((EditText)findViewById(R.id.campoEmpresa)).getText().toString();
            String conductor = ((EditText)findViewById(R.id.campoConductor)).getText().toString();
            String compania_seguro = ((EditText)findViewById(R.id.campoCompaniaSeguro)).getText().toString();
            Integer veh_estado = 0;

            Vehiculo vehiculo = new Vehiculo(codigoOriginal,clase,placa,modelo,propietario,soat,servicio,marca,empresa,conductor,compania_seguro,veh_estado);

            int result = vehiculo.update(dbOpenHelper.getWritableDatabase());

            if(result==1){
                Toast.makeText(getApplicationContext(),getString(R.string.success_update),Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),getString(R.string.error_update),Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e(TAG,"Error actualizando el vehiculo",e);
            Toast.makeText(getApplicationContext(),getString(R.string.error_update),Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_insert, menu);
        return false;
    }
}