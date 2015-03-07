package com.s4.demodb;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.s4.demodb.db.UsuariosDBOpenHelper;
import com.s4.demodb.db.util.Usuario;
import com.s4.demodb.util.ActivityNavigationListener;

import java.util.logging.Logger;


public class InsertActivity extends ActionBarActivity {

    private UsuariosDBOpenHelper dbOpenHelper;
    private static final String TAG = "InsertActivity";

    private ActivityNavigationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        Button buttonInsert = (Button) findViewById(R.id.buttonInsert);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertarRegistro();

            }
        });

    }

    private void insertarRegistro() {

        try {

            Integer code = Integer.parseInt(((EditText)findViewById(R.id.campoCodigo)).getText().toString());
            String name = ((EditText)findViewById(R.id.campoNombre)).getText().toString();
            String password = ((EditText)findViewById(R.id.campoContrasena)).getText().toString();



            Usuario usuario = new Usuario(name,password,code);

            long result = usuario.insert(dbOpenHelper.getWritableDatabase());

            if(result!=-1){
                Toast.makeText(getApplicationContext(),getString(R.string.success_insert),Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),getString(R.string.error_insert),Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e(TAG,"Error creando usuario",e);
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
