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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.s4.demodb.db.UsuariosDBOpenHelper;
import com.s4.demodb.db.util.Emergencia;
import com.s4.demodb.util.ActivityNavigationListenerEmergencia;


public class UpdateActivityEmergencia extends ActionBarActivity {

    private UsuariosDBOpenHelper dbOpenHelper;
    private static final String TAG = "UpdateActivityEmergencia";
    private Emergencia emergencia;
    private Integer codigoOriginal;

    private ActivityNavigationListenerEmergencia listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_emergencia);

        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        if(getIntent().hasExtra(ListEmergenciaActivity.KEY_USUARIO)){
            emergencia = (Emergencia) getIntent().getSerializableExtra(ListEmergenciaActivity.KEY_USUARIO);
            codigoOriginal = emergencia.getEmeId();
            System.out.println("Codigo Original traido de bd = "+codigoOriginal);
        }else{
            setResult(Activity.RESULT_CANCELED);
            finish();
        }

        loadData();

        Button buttonInsert = (Button) findViewById(R.id.buttonInsertEmergencia);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertarRegistro();

            }
        });

    }

    private void loadData() {

        //Cargamos Fecha
        EditText fecha = (EditText) findViewById(R.id.campofecha);
        fecha.setText(emergencia.getEmeFecha());
        System.out.println("Fecha = "+fecha.getText());
        //Cargamos Hora
        EditText hora = (EditText) findViewById(R.id.campoHora);
        hora.setText(emergencia.getEmeHora());
        System.out.println("Hora = "+hora.getText());
        //Cargamos con el codigo del Informante
        EditText informante = (EditText) findViewById(R.id.campoInformante);
        informante.setText(emergencia.getEmeInformante().toString());
        System.out.println("Codigo Informante = "+informante.getText());
        //Cargamos la informacion recibida de la emergencia
        EditText informacionr = (EditText) findViewById(R.id.campoInformacionr);
        informacionr.setText(emergencia.getEmeInformacionRecibida());
        System.out.println("Informacion Recibida = "+informacionr.getText());
        //Cargamos el medio de Informacion

        //Cargamos la descripcion de otro medio de informacion
        EditText otroMedioInformacion = (EditText) findViewById(R.id.campoOtro_medio);
        otroMedioInformacion .setText(emergencia.getEmeDescripcionOtroMedio());
        System.out.println("Descripcion Otro medio Informacion = "+otroMedioInformacion.getText());
        //Cargamos la Persona que confirma
        EditText personaConfirmacion = (EditText) findViewById(R.id.campoPersona_confirmacion);
        personaConfirmacion.setText(emergencia.getEmePersonaConfirmacion());
        System.out.println("Persona Confirmacion = "+personaConfirmacion.getText());

        //Cargamos el medio de Confirmacion

        //Cargamos la descripcion del otro medio de Confirmacion
        EditText otroMedioConfirmacion = (EditText) findViewById(R.id.campoMedio_confirmacion);
        otroMedioConfirmacion .setText(emergencia.getEmeDescripcionOtroMedioC());
        System.out.println("Descripcion Otro medio Confirmacion = "+otroMedioConfirmacion.getText());
        //Cargamos la Direccion
        EditText direccion = (EditText) findViewById(R.id.campoDireccion);
        direccion.setText(emergencia.getEmeDireccion());
        System.out.println("Direccion = "+direccion.getText());
        //Cargamos la clase del inmmuebl

        //Cargamos el Propietario del Inmueble
        EditText propietario = (EditText) findViewById(R.id.campoPropietario_inmmueble);
        propietario.setText(emergencia.getEmeInmueblePropietario());
        System.out.println("Inmueble Propietario = "+propietario.getText());
        //Cargamos el Administrador del Inmueble
        EditText administrador = (EditText) findViewById(R.id.campoInmueble_administrador);
        administrador .setText(emergencia.getEmeInmuebleAdministrador());
        System.out.println("Inmueble Administrador = "+administrador.getText());
        //Cargamos el Arrendatario del Inmueble
        EditText arrendatario = (EditText) findViewById(R.id.campoInmueble_arrendatario);
        arrendatario.setText(emergencia.getEmeInmuebleArrendatario());
        System.out.println("Inmueble Arrendatario = "+arrendatario.getText());
        //Cargamos las Novedades
        EditText novedades = (EditText) findViewById(R.id.campoNovedades);
        novedades.setText(emergencia.getEmeNovedades());
        System.out.println("Novedades = "+novedades.getText());
        //Cargamos el Comandante del Incidente
        EditText comandante = (EditText) findViewById(R.id.campoComandante);
        comandante.setText(emergencia.getEmeComandante().toString());
        System.out.println("Comandante = "+comandante.getText());
        setTitle(getTitle().toString().concat(" ").concat(" "+emergencia.getEmeId().toString()));
    }

    private void insertarRegistro() {

        try {

            RadioGroup grupoMedioInformacion = (RadioGroup) findViewById(R.id.medioInformacion);
            RadioGroup grupoMedioConfirmacion = (RadioGroup) findViewById(R.id.medioConfirmacion);
            RadioGroup grupoClaseInmueble = (RadioGroup) findViewById(R.id.claseInmueble);
            RadioButton radioMedioInformacion = (RadioButton) findViewById(grupoMedioInformacion.getCheckedRadioButtonId());
            RadioButton radioMedioConfirmacion = (RadioButton) findViewById(grupoMedioConfirmacion.getCheckedRadioButtonId());
            RadioButton radioClaseInmueble = (RadioButton) findViewById(grupoClaseInmueble.getCheckedRadioButtonId());

            String fecha = ((EditText)findViewById(R.id.campofecha)).getText().toString();
            String hora = ((EditText)findViewById(R.id.campoHora)).getText().toString();
            String informante = ((EditText)findViewById(R.id.campoInformante)).getText().toString();
            Integer informante2 = Integer.parseInt(informante);
            String informacion_recibida = ((EditText)findViewById(R.id.campoInformacionr)).getText().toString();
            String medio_informacion = radioMedioInformacion.getText().toString();
            Integer medio_informacion2= 0;
            if (medio_informacion.equals("Personalmente"))
            {
                medio_informacion2=0;
            }
            else
            if (medio_informacion.equals("Teléfono"))
            {
                medio_informacion2=1;
            }
            else
            if (medio_informacion.equals("Otros"))
            {
                medio_informacion2=2;
            }
            String otro_medio_informacion = ((EditText)findViewById(R.id.campoOtro_medio)).getText().toString();
            String persona_confirmacion = ((EditText)findViewById(R.id.campoPersona_confirmacion)).getText().toString();
            String medio_confirmacion = radioMedioConfirmacion.getText().toString();
            Integer medio_confirmacion2 = 0;
            if (medio_confirmacion.equals("Personalmente"))
            {
                medio_confirmacion2=0;
            }
            else
            if (medio_confirmacion.equals("Teléfono"))
            {
                medio_confirmacion2=1;
            }
            else
            if (medio_confirmacion.equals("Otros"))
            {
                medio_confirmacion2=2;
            }
            String descripcion_otro_medio = ((EditText)findViewById(R.id.campoMedio_confirmacion)).getText().toString();
            String direccion = ((EditText)findViewById(R.id.campoDireccion)).getText().toString();
            String inmueble_clase = radioClaseInmueble.getText().toString();
            Integer inmueble_clase2 = 0;
            if (inmueble_clase.equals("Residencial"))
            {
                inmueble_clase2=0;
            }
            else
            if (inmueble_clase.equals("Comercial"))
            {
                inmueble_clase2=1;
            }
            else
            if (inmueble_clase.equals("Industrial"))
            {
                inmueble_clase2=2;
            }
            String inmueble_propietario = ((EditText)findViewById(R.id.campoPropietario_inmmueble)).getText().toString();
            String inmueble_administrador = ((EditText)findViewById(R.id.campoInmueble_administrador)).getText().toString();
            String inmueble_arrendatario = ((EditText)findViewById(R.id.campoInmueble_arrendatario)).getText().toString();
            String novedades = ((EditText)findViewById(R.id.campoNovedades)).getText().toString();
            String comandante  = ((EditText)findViewById(R.id.campoComandante)).getText().toString();
            Integer comandante2 = Integer.parseInt(comandante);
            Integer estado = 0;
//            String tipoe  = ((EditText)findViewById(R.id.campoTipoe)).getText().toString();
            Integer tipoe2 = Integer.parseInt("1");


            Emergencia emergencia = new Emergencia(codigoOriginal,fecha, hora, informante2, informacion_recibida, medio_informacion2, otro_medio_informacion, persona_confirmacion, medio_confirmacion2, descripcion_otro_medio, direccion, inmueble_clase2, inmueble_propietario, inmueble_administrador, inmueble_arrendatario, novedades, comandante2, estado, tipoe2);

            int result = emergencia.update(dbOpenHelper.getWritableDatabase());

            if(result==1){
                Toast.makeText(getApplicationContext(),getString(R.string.success_update),Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),getString(R.string.error_update),Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e(TAG,"Error actualizando la Emergencia",e);
            Toast.makeText(getApplicationContext(),getString(R.string.error_update),Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_insert, menu);
        return false;
    }
}