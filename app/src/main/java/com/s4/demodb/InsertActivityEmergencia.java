package com.s4.demodb;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.s4.demodb.db.UsuariosDBOpenHelper;
import com.s4.demodb.db.util.Emergencia;
import com.s4.demodb.util.ActivityNavigationListenerEmergencia;


public class InsertActivityEmergencia extends ActionBarActivity {

    private UsuariosDBOpenHelper dbOpenHelper;
    private static final String TAG = "InsertActivityEmergencia";

    private ActivityNavigationListenerEmergencia listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_emergencia);

        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        Button buttonInsert = (Button) findViewById(R.id.buttonInsertEmergencia);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertarRegistro();

            }
        });

    }

    private void insertarRegistro() {

        try {
            String fecha = ((EditText)findViewById(R.id.campofecha)).getText().toString();
            String hora = ((EditText)findViewById(R.id.campoHora)).getText().toString();
            String informante = ((EditText)findViewById(R.id.campoInformante)).getText().toString();
            Integer informante2 = Integer.parseInt(informante);
            String informacion_recibida = ((EditText)findViewById(R.id.campoInformacionr)).getText().toString();
            String medio_informacion = ((RadioButton)findViewById(R.id.medioInformacion)).getText().toString();
            Integer medio_informacion2 =Integer.parseInt(medio_informacion);
            String otro_medio_informacion = ((EditText)findViewById(R.id.campoOtro_medio)).getText().toString();
            String persona_confirmacion = ((EditText)findViewById(R.id.campoPersona_confirmacion)).getText().toString();
            String medio_confirmacion = ((EditText)findViewById(R.id.medioConfirmacion)).getText().toString();
            Integer medio_confirmacion2 = Integer.parseInt(medio_confirmacion);
            String descripcion_otro_medio = ((EditText)findViewById(R.id.campoMedio_confirmacion)).getText().toString();
            String direccion = ((EditText)findViewById(R.id.campoDireccion)).getText().toString();
            String inmueble_clase = ((EditText)findViewById(R.id.campoClase_inmueble)).getText().toString();
            Integer inmueble_clase2 = Integer.parseInt(inmueble_clase);
            String inmueble_propietario = ((EditText)findViewById(R.id.campoPropietario_inmmueble)).getText().toString();
            String inmueble_administrador = ((EditText)findViewById(R.id.campoInmueble_administrador)).getText().toString();
            String inmueble_arrendatario = ((EditText)findViewById(R.id.campoInmueble_arrendatario)).getText().toString();
            String novedades = ((EditText)findViewById(R.id.campoNovedades)).getText().toString();
            String comandante  = ((EditText)findViewById(R.id.campoComandante)).getText().toString();
            Integer comandante2 = Integer.parseInt(comandante);
            Integer estado = 0;
            String tipoe  = ((EditText)findViewById(R.id.campoTipoe)).getText().toString();
            Integer tipoe2 = Integer.parseInt(tipoe);

            Emergencia emergencia = new Emergencia(null, fecha, hora, informante2, informacion_recibida, medio_informacion2, otro_medio_informacion, persona_confirmacion, medio_confirmacion2, descripcion_otro_medio, direccion, inmueble_clase2, inmueble_propietario, inmueble_administrador, inmueble_arrendatario, novedades, comandante2, estado, tipoe2);

            long result = emergencia.insert(dbOpenHelper.getWritableDatabase());

            if(result!=-1){
                Toast.makeText(getApplicationContext(),getString(R.string.success_insert),Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),getString(R.string.error_insert),Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e(TAG,"Error creando la emergencia",e);
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
