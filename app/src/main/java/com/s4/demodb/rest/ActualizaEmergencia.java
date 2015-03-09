package com.s4.demodb.rest;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.s4.demodb.R;
import com.s4.demodb.db.UsuariosDBOpenHelper;
import com.s4.demodb.db.util.Emergencia;
import com.s4.demodb.rest.auxi.RestHelper;

import java.util.List;

public class ActualizaEmergencia extends ActionBarActivity {

    private TextView view;
    private UsuariosDBOpenHelper dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualiza_emergencia);

        view = (TextView) findViewById(R.id.label_json);
        dbOpenHelper = UsuariosDBOpenHelper.getInstance(this);

        new HttpAsyncTask().execute("");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actualiza_emergencia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, Boolean> {

        private List<Emergencia> emergencias;

        @Override
        protected Boolean doInBackground(String... objects) {

            SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
            emergencias = Emergencia.getList(db, false);

            final String json = new Gson().toJson(emergencias);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    view.setText(json);
                }
            });

            String direccion = PreferenceManager.getDefaultSharedPreferences(ActualizaEmergencia.this.getApplicationContext()).getString("direccion_ip","127.0.0.1");
            String dispositivo = PreferenceManager.getDefaultSharedPreferences(ActualizaEmergencia.this.getApplicationContext()).getString("dispositivo","TABLET1");

            return RestHelper.POST("http://"+direccion+":8080/BomberApp/ws/vehiculo?dispositivo="+dispositivo, json);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(Boolean result) {
            String mensaje = "Data not sent!";
            if(result){
                mensaje = "Data Sent!";

                SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

                for (Emergencia emergencia: emergencias){
                    emergencia.setEmeEstado(1);
                    emergencia.update(db);
                }

            }
            Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG).show();
        }
    }

}
