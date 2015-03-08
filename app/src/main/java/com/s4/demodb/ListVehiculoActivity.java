package com.s4.demodb;

import android.app.Activity;
import android.content.Intent;
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
import com.s4.demodb.db.util.Vehiculo;
import com.s4.demodb.db.util.VehiculoListAdapter;
//import com.s4.demodb.util.ActivityNavigationListener;
import com.s4.demodb.util.ActivityNavigationListenerVehiculo;
import com.s4.demodb.util.DeleteDialogVehiculo;

import java.util.List;


public class ListVehiculoActivity extends ActionBarActivity implements ActivityNavigationListenerVehiculo {


    private UsuariosDBOpenHelper dbOpenHelper;
    private VehiculoListAdapter adapter;

    public static final int REQUEST_CREATE = 1;
    public static final String KEY_USUARIO = "key_usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehiculo_main);
        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);
        setUpList();
    }

    private void setUpList() {

        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        List<Vehiculo> vehiculos = Vehiculo.getList(db,true);
        adapter = new VehiculoListAdapter(this,vehiculos);
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
                Intent intent = new Intent(this,UpdateActivityVehiculo.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,REQUEST_CREATE);
                return true;
            case R.id.action_delete:
                FragmentManager fragmentManager = getSupportFragmentManager();
                DeleteDialogVehiculo dialog = new DeleteDialogVehiculo();

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
            Intent intent = new Intent(this,InsertActivityVehiculo.class);
            startActivityForResult(intent, REQUEST_CREATE);
        }
        else if(id == R.id.action_refresh){
            setUpList();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogPositiveClick(DeleteDialogVehiculo dialog) {

        Vehiculo vehiculo = dialog.getVehiculo();

        if(vehiculo.remove(dbOpenHelper.getWritableDatabase())==1){
            Toast.makeText(getApplicationContext(),
                    getString(R.string.delete_message_vehiculo).concat(" "+vehiculo.getVehPlaca()),Toast.LENGTH_SHORT)
                    .show();
            setUpList();
        }else{
            Toast.makeText(getApplicationContext(),
                    getString(R.string.delete_error_vehiculo).concat(" "+vehiculo.getVehPlaca()),Toast.LENGTH_SHORT)
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
