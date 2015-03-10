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
                Intent intent = new Intent(this,UpdateActivityEmergencia.class);
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
