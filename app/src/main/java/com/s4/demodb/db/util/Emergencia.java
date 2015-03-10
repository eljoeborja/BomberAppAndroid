package com.s4.demodb.db.util;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by eljoeborja on 1/6/15.
 */
public class Emergencia implements Serializable{
    private Integer emeId;
    private String emeFecha;
    private String emeHora;
    private Integer emeInformante;
    private String emeInformacionRecibida;
    private Integer emeMedioInformacion;
    private String emeDescripcionOtroMedio;
    private String emePersonaConfirmacion;
    private Integer emeMedioConfirmacion;
    private String emeDescripcionOtroMedioC;
    private String emeDireccion;
    private Integer emeInmuebleClase;
    private String emeInmueblePropietario;
    private String emeInmuebleAdministrador;
    private String emeInmuebleArrendatario;
    private String emeNovedades;
    private Integer emeComandante;
    private Integer emeEstado;
    private Integer emeTipoe;
    //Constructor
    public Emergencia(Integer id, String fecha, String hora, Integer informante, String informacion_recibida, Integer medio_informacion, String otro_medio_informacion, String persona_confirmacion, Integer medio_confirmacion, String descripcion_otro_medio, String direccion, Integer inmueble_clase, String inmueble_propietario, String inmueble_administrador, String inmueble_arrendatario, String novedades, Integer comandante, Integer estado, Integer tipoe) {
        this.emeId = id;
        this.emeFecha = fecha;
        this.emeHora = hora;
        this.emeInformante = informante;
        this.emeInformacionRecibida = informacion_recibida;
        this.emeMedioInformacion = medio_informacion;
        this.emeDescripcionOtroMedio = otro_medio_informacion;
        this.emePersonaConfirmacion = persona_confirmacion;
        this.emeMedioConfirmacion = medio_confirmacion;
        this.emeDescripcionOtroMedioC = descripcion_otro_medio;
        this.emeDireccion = direccion;
        this.emeInmuebleClase = inmueble_clase;
        this.emeInmueblePropietario = inmueble_propietario;
        this.emeInmuebleAdministrador = inmueble_administrador;
        this.emeInmuebleArrendatario = inmueble_arrendatario;
        this.emeNovedades = novedades;
        this.emeComandante = comandante;
        this.emeEstado = estado;
        this.emeTipoe = tipoe;
    }
    //Implementacion Getters and Setters

    public Integer getEmeId() {
        return emeId;
    }

    public void setEmeId(Integer emeId) {
        this.emeId = emeId;
    }

    public String getEmeFecha() {
        return emeFecha;
    }

    public void setEmeFecha(String emeFecha) {
        this.emeFecha = emeFecha;
    }

    public String getEmeHora() {
        return emeHora;
    }

    public void setEmeHora(String emeHora) {
        this.emeHora = emeHora;
    }

    public Integer getEmeInformante() {
        return emeInformante;
    }

    public void setEmeInformante(Integer emeInformante) {
        this.emeInformante = emeInformante;
    }

    public String getEmeInformacionRecibida() {
        return emeInformacionRecibida;
    }

    public void setEmeInformacionRecibida(String emeInformacionRecibida) {
        this.emeInformacionRecibida = emeInformacionRecibida;
    }

    public Integer getEmeMedioInformacion() {
        return emeMedioInformacion;
    }

    public void setEmeMedioInformacion(Integer emeMedioInformacion) {
        this.emeMedioInformacion = emeMedioInformacion;
    }

    public String getEmeDescripcionOtroMedio() {
        return emeDescripcionOtroMedio;
    }

    public void setEmeDescripcionOtroMedio(String emeDescripcionOtroMedio) {
        this.emeDescripcionOtroMedio = emeDescripcionOtroMedio;
    }

    public String getEmePersonaConfirmacion() {
        return emePersonaConfirmacion;
    }

    public void setEmePersonaConfirmacion(String emePersonaConfirmacion) {
        this.emePersonaConfirmacion = emePersonaConfirmacion;
    }

    public Integer getEmeMedioConfirmacion() {
        return emeMedioConfirmacion;
    }

    public void setEmeMedioConfirmacion(Integer emeMedioConfirmacion) {
        this.emeMedioConfirmacion = emeMedioConfirmacion;
    }

    public String getEmeDescripcionOtroMedioC() {
        return emeDescripcionOtroMedioC;
    }

    public void setEmeDescripcionOtroMedioC(String emeDescripcionOtroMedioC) {
        this.emeDescripcionOtroMedioC = emeDescripcionOtroMedioC;
    }

    public String getEmeDireccion() {
        return emeDireccion;
    }

    public void setEmeDireccion(String emeDireccion) {
        this.emeDireccion = emeDireccion;
    }

    public Integer getEmeInmuebleClase() {
        return emeInmuebleClase;
    }

    public void setEmeInnmuebleClase(Integer emeInmuebleClase) {
        this.emeInmuebleClase = emeInmuebleClase;
    }

    public String getEmeInmueblePropietario() {
        return emeInmueblePropietario;
    }

    public void setEmeInmueblePropietario(String emeInmueblePropietario) {
        this.emeInmueblePropietario = emeInmueblePropietario;
    }

    public String getEmeInmuebleAdministrador() {
        return emeInmuebleAdministrador;
    }

    public void setEmeInmuebleAdministrador(String emeInmuebleAdministrador) {
        this.emeInmuebleAdministrador = emeInmuebleAdministrador;
    }

    public String getEmeInmuebleArrendatario() {
        return emeInmuebleArrendatario;
    }

    public void setEmeInmuebleArrendatario(String emeInmuebleArrendatario) {
        this.emeInmuebleArrendatario = emeInmuebleArrendatario;
    }

    public String getEmeNovedades() {
        return emeNovedades;
    }

    public void setEmeNovedades(String emeNovedades) {
        this.emeNovedades = emeNovedades;
    }

    public Integer getEmeComandante() {
        return emeComandante;
    }

    public void setEmeComandante(Integer emeComandante) {
        this.emeComandante = emeComandante;
    }

    public Integer getEmeEstado() {
        return emeEstado;
    }

    public void setEmeEstado(Integer emeEstado) {
        this.emeEstado = emeEstado;
    }

    public Integer getEmeTipoe() {
        return emeTipoe;
    }

    public void setEmeTipoe(Integer emeTipoe) {
        this.emeTipoe = emeTipoe;
    }

    //Finalizacion de los Getters and Setters
    //Implementacion metodo ToString
    @Override
    public String toString() {
        return "Emergencia{" +
                "id='" + emeId + '\'' +
                ", fecha=" + emeFecha +
                ", hora='" + emeHora + '\'' +
                ", informante=" + emeInformante +
                ", informacion_recibida='" + emeInformacionRecibida + '\'' +
                ", medio_informacion=" + emeMedioInformacion +
                ", otro_medio_informacion='" + emeDescripcionOtroMedio + '\'' +
                ", persona_confirmacion='" + emePersonaConfirmacion + '\'' +
                ", medio_confirmacion=" + emeMedioConfirmacion +
                ", descripcion_otro_medio='" + emeDescripcionOtroMedioC + '\'' +
                ", direccion='" + emeDireccion + '\'' +
                ", inmueble_clase=" + emeInmuebleClase +
                ", inmueble_propietario='" + emeInmueblePropietario + '\'' +
                ", inmueble_administrador='" + emeInmuebleAdministrador + '\'' +
                ", inmueble_arrendatario='" + emeInmuebleArrendatario + '\'' +
                ", novedades='" + emeNovedades + '\'' +
                ", comandante=" + emeComandante +
                ", estado=" + emeEstado +
                ", tipoe=" + emeTipoe +
                '}';
    }
    public long insert(SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("eme_id",emeId);
        contentValues.put("eme_fecha", emeFecha.toString());
        contentValues.put("eme_hora",emeHora);
        contentValues.put("eme_informante",emeInformante);
        contentValues.put("eme_informacion_recibida",emeInformacionRecibida);
        contentValues.put("eme_medio_informacion",emeMedioInformacion);
        contentValues.put("eme_descripcion_otro_medio",emeDescripcionOtroMedio);
        contentValues.put("eme_persona_confirmacion",emePersonaConfirmacion);
        contentValues.put("eme_medio_confirmacion",emeMedioConfirmacion);
        contentValues.put("eme_descripcion_otro_medio_c",emeDescripcionOtroMedioC);
        contentValues.put("eme_direccion",emeDireccion);
        contentValues.put("eme_inmueble_clase",emeInmuebleClase);
        contentValues.put("eme_inmueble_propietario",emeInmueblePropietario);
        contentValues.put("eme_inmueble_administrador",emeInmuebleAdministrador);
        contentValues.put("eme_inmueble_arrendatario",emeInmuebleArrendatario);
        contentValues.put("eme_novedades",emeNovedades);
        contentValues.put("eme_comandante",emeComandante);
        contentValues.put("eme_estado",emeEstado);
        contentValues.put("eme_tipoe",emeTipoe);
        return db.insert("emergencia",null,contentValues);
    }
    public int update(SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("eme_id",emeId);
        contentValues.put("eme_fecha", emeFecha.toString());
        contentValues.put("eme_hora",emeHora);
        contentValues.put("eme_informante",emeInformante);
        contentValues.put("eme_informacion_recibida",emeInformacionRecibida);
        contentValues.put("eme_medio_informacion",emeMedioInformacion);
        contentValues.put("eme_descripcion_otro_medio",emeDescripcionOtroMedio);
        contentValues.put("eme_persona_confirmacion",emePersonaConfirmacion);
        contentValues.put("eme_medio_confirmacion",emeMedioConfirmacion);
        contentValues.put("eme_descripcion_otro_medio_c",emeDescripcionOtroMedioC);
        contentValues.put("eme_direccion",emeDireccion);
        contentValues.put("eme_inmueble_clase",emeInmuebleClase);
        contentValues.put("eme_inmueble_propietario",emeInmueblePropietario);
        contentValues.put("eme_inmueble_administrador",emeInmuebleAdministrador);
        contentValues.put("eme_inmueble_arrendatario",emeInmuebleArrendatario);
        contentValues.put("eme_novedades",emeNovedades);
        contentValues.put("eme_comandante",emeComandante);
        contentValues.put("eme_estado",emeEstado);
        contentValues.put("eme_tipoe",emeTipoe);
        String params[] = new String[]{emeId.toString()};
        return db.update("emergencia",contentValues,"eme_id=?",params);
    }
    public int remove(SQLiteDatabase db){
        String[] args = new String[]{emeId.toString()};
        int result = db.delete("emergencia","eme_id=?",args);
        return result;
    }
    /**
     * Consultar la lista de vehiculos dentro de la base de datos
     * @param db base de datos en modo lectura
     * @param todos si es verdadero, me retorna todos los vehiculos, sino solo los que se editaron o crearon
     * @return listado de vehiculos
     */
    public static List<Emergencia> getList(SQLiteDatabase db, boolean todos){

        String where = null;
        String[] params = null;
        if(!todos){
            where = "eme_estado = ?";
            params = new String[]{"0"};
        }

        Cursor c = db.query("emergencia", null, where, params, null, null, null);

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
        return emergencias;
    }
}
