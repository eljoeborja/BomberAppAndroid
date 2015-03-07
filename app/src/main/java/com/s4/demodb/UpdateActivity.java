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
import com.s4.demodb.db.util.Usuario;
import com.s4.demodb.util.ActivityNavigationListener;


public class UpdateActivity extends ActionBarActivity {

    private UsuariosDBOpenHelper dbOpenHelper;
    private static final String TAG = "UpdateActivity";
    private Usuario usuario;
    private Integer codigoOriginal;

    private ActivityNavigationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        if(getIntent().hasExtra(MainActivity.KEY_USUARIO)){
            usuario = (Usuario) getIntent().getSerializableExtra(MainActivity.KEY_USUARIO);
            codigoOriginal = usuario.getCode();
        }else{
            setResult(Activity.RESULT_CANCELED);
            finish();
        }

        loadData();

        Button buttonInsert = (Button) findViewById(R.id.buttonInsert);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertarRegistro();

            }
        });

    }

    private void loadData() {

        EditText campoCode = (EditText) findViewById(R.id.campoCodigo);
        EditText campoContrasena = (EditText) findViewById(R.id.campoContrasena);
        EditText campoNombre = (EditText) findViewById(R.id.campoNombre);

        campoCode.setText(usuario.getCode().toString());
        campoContrasena.setText(usuario.getPassword());
        campoNombre.setText(usuario.getName());

        setTitle(getTitle().toString().concat(" ").concat(usuario.getName()));

    }

    private void insertarRegistro() {

        try {

            Integer code = Integer.parseInt(((EditText)findViewById(R.id.campoCodigo)).getText().toString());
            String name = ((EditText)findViewById(R.id.campoNombre)).getText().toString();
            String password = ((EditText)findViewById(R.id.campoContrasena)).getText().toString();

            Usuario usuario = new Usuario(name,password,code);

            int result = usuario.update(dbOpenHelper.getWritableDatabase(),codigoOriginal);

            if(result==1){
                Toast.makeText(getApplicationContext(),getString(R.string.success_update),Toast.LENGTH_LONG).show();
                setResult(Activity.RESULT_OK);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),getString(R.string.error_update),Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e(TAG,"Error actualizando usuario",e);
            Toast.makeText(getApplicationContext(),getString(R.string.error_update),Toast.LENGTH_SHORT).show();
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
