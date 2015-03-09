package com.s4.demodb;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.s4.demodb.db.UsuariosDBOpenHelper;
import com.s4.demodb.db.util.Emergencia;
import com.s4.demodb.db.util.EmergenciaListAdapter;
import com.s4.demodb.db.util.VehiculoListAdapter;
import com.s4.demodb.util.ActivityNavigationListenerEmergencia;
import com.s4.demodb.util.DeleteDialogEmergencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ListEmergenciaActivity extends ActionBarActivity implements ActivityNavigationListenerEmergencia {


    private UsuariosDBOpenHelper dbOpenHelper;
    private EmergenciaListAdapter adapter;

    public static final int REQUEST_CREATE = 1;
    public static final String KEY_USUARIO = "key_usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergencia_main);
        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);
        setUpList();
    }

    private void setUpList() {

        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        List<Emergencia> emergencias = Emergencia.getList(db,true);
        adapter = new EmergenciaListAdapter(this,emergencias);
        ListView listView = (ListView) findViewById(R.id.listado);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);


/*
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.query("emergencia", null, null, null, null, null, null);
        List<Emergencia> emergencias = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                Integer id = Integer.parseInt(c.getString(0));
                String fecha = c.getString(1);
                String hora = c.getString(2);
                Integer informante = Integer.parseInt(c.getString(3));
                String informacion_recibida = c.getString(4);
                Integer medio_informacion = Integer.parseInt(c.getString(5));
                String otro_medio_informacion = c.getString(6);
                String persona_confirmacion = c.getString(7);
                Integer medio_confirmacion = Integer.parseInt(c.getString(8));
                String descripcion_otro_medio = c.getString(9);
                String direccion = c.getString(10);
                Integer inmueble_clase = Integer.parseInt(c.getString(11));
                String inmueble_propietario = c.getString(12);
                String inmueble_administrador = c.getString(13);
                String inmueble_arrendatario = c.getString(14);
                String novedades = c.getString(15);
                Integer comandante = Integer.parseInt(c.getString(16));
                Integer estado = Integer.parseInt(c.getString(17));
                Integer tipoe = Integer.parseInt(c.getString(18));
                Emergencia emergencia = new Emergencia(id, fecha, hora, informante, informacion_recibida, medio_informacion, otro_medio_informacion, persona_confirmacion, medio_confirmacion, descripcion_otro_medio, direccion, inmueble_clase, inmueble_propietario, inmueble_administrador, inmueble_arrendatario, novedades, comandante, estado, tipoe);
                emergencias.add(emergencia);
            }while (c.moveToNext());
        }
        adapter = new EmergenciaListAdapter(this,emergencias);
        ListView listView = (ListView) findViewById(R.id.listado);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);*/
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_usuario_item, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_USUARIO,adapter.getItem(info.position));

        switch (item.getItemId()){
            case R.id.action_update:
                Intent intent = new Intent(this,UpdateActivityVehiculo.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,REQUEST_CREATE);
                return true;
            case R.id.action_delete:
                FragmentManager fragmentManager = getSupportFragmentManager();
                DeleteDialogEmergencia dialog = new DeleteDialogEmergencia();

                dialog.setArguments(bundle);
                dialog.show(fragmentManager,"Confirmacion");
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_insert) {
            Intent intent = new Intent(this,InsertActivityEmergencia.class);
            startActivityForResult(intent, REQUEST_CREATE);
        }
        else if(id == R.id.action_refresh){
            setUpList();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogPositiveClick(DeleteDialogEmergencia dialog) {

        Emergencia emergencia = dialog.getEmergencia();

        if(emergencia.remove(dbOpenHelper.getWritableDatabase())==1){
            Toast.makeText(getApplicationContext(),
                    getString(R.string.delete_message_emergencia).concat(" "+emergencia.getEmeFecha()).concat("-"+emergencia.getEmeDireccion()),Toast.LENGTH_SHORT)
                    .show();
            setUpList();
        }else{
            Toast.makeText(getApplicationContext(),
                    getString(R.string.delete_error_emergencia).concat(" "+emergencia.getEmeFecha()).concat("-"+emergencia.getEmeDireccion()),Toast.LENGTH_SHORT)
                    .show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CREATE){
            if(resultCode== Activity.RESULT_OK){
                setUpList();
            }
        }
    }
}
