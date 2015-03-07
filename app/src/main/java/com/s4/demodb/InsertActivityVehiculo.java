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
import com.s4.demodb.util.ActivityNavigationListenerVehiculo;


public class InsertActivityVehiculo extends ActionBarActivity {

    private UsuariosDBOpenHelper dbOpenHelper;
    private static final String TAG = "InsertActivityVehiculo";

    private ActivityNavigationListenerVehiculo listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vehiculo);

        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        Button buttonInsert = (Button) findViewById(R.id.buttonInsertVehiculo);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertarRegistro();

            }
        });

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

            Vehiculo vehiculo = new Vehiculo(null,clase,placa,modelo,propietario,soat,servicio,marca,empresa,conductor,compania_seguro,veh_estado);

            long result = vehiculo.insert(dbOpenHelper.getWritableDatabase());

            if(result!=-1){
                Toast.makeText(getApplicationContext(),getString(R.string.success_insert),Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),getString(R.string.error_insert),Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e(TAG,"Error creando vehiculo",e);
            Toast.makeText(getApplicationContext(),getString(R.string.error_insert),Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_insert, menu);
        return false;
    }


    //    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
