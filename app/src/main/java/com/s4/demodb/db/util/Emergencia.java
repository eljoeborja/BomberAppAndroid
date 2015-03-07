package com.s4.demodb.db.util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by eljoeborja on 1/6/15.
 */
public class Emergencia implements Serializable{

    private Integer id;
    private String fecha;
    private String hora;
    private Integer informante;
    private String informacion_recibida;
    private Integer medio_informacion;
    private String otro_medio_informacion;
    private String persona_confirmacion;
    private Integer medio_confirmacion;
    private String descripcion_otro_medio;
    private String direccion;
    private Integer inmueble_clase;
    private String inmueble_propietario;
    private String inmueble_administrador;
    private String inmueble_arrendatario;
    private String novedades;
    private Integer comandante;
    private Integer estado;
    private Integer tipoe;

    //Constructor
    public Emergencia(Integer id, String fecha, String hora, Integer informante, String informacion_recibida, Integer medio_informacion, String otro_medio_informacion, String persona_confirmacion, Integer medio_confirmacion, String descripcion_otro_medio, String direccion, Integer inmueble_clase, String inmueble_propietario, String inmueble_administrador, String inmueble_arrendatario, String novedades, Integer comandante, Integer estado, Integer tipoe) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.informante = informante;
        this.informacion_recibida = informacion_recibida;
        this.medio_informacion = medio_informacion;
        this.otro_medio_informacion = otro_medio_informacion;
        this.persona_confirmacion = persona_confirmacion;
        this.medio_confirmacion = medio_confirmacion;
        this.descripcion_otro_medio = descripcion_otro_medio;
        this.direccion = direccion;
        this.inmueble_clase = inmueble_clase;
        this.inmueble_propietario = inmueble_propietario;
        this.inmueble_administrador = inmueble_administrador;
        this.inmueble_arrendatario = inmueble_arrendatario;
        this.novedades = novedades;
        this.comandante = comandante;
        this.estado = estado;
        this.tipoe = tipoe;
    }

    //Implementacion Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getInformante() {
        return informante;
    }

    public void setInformante(Integer informante) {
        this.informante = informante;
    }

    public String getInformacion_recibida() {
        return informacion_recibida;
    }

    public void setInformacion_recibida(String informacion_recibida) {
        this.informacion_recibida = informacion_recibida;
    }

    public Integer getMedio_informacion() {
        return medio_informacion;
    }

    public void setMedio_informacion(Integer medio_informacion) {
        this.medio_informacion = medio_informacion;
    }

    public String getOtro_medio_informacion() {
        return otro_medio_informacion;
    }

    public void setOtro_medio_informacion(String otro_medio_informacion) {
        this.otro_medio_informacion = otro_medio_informacion;
    }

    public String getPersona_confirmacion() {
        return persona_confirmacion;
    }

    public void setPersona_confirmacion(String persona_confirmacion) {
        this.persona_confirmacion = persona_confirmacion;
    }

    public Integer getMedio_confirmacion() {
        return medio_confirmacion;
    }

    public void setMedio_confirmacion(Integer medio_confirmacion) {
        this.medio_confirmacion = medio_confirmacion;
    }

    public String getDescripcion_otro_medio() {
        return descripcion_otro_medio;
    }

    public void setDescripcion_otro_medio(String descripcion_otro_medio) {
        this.descripcion_otro_medio = descripcion_otro_medio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getInmueble_clase() {
        return inmueble_clase;
    }

    public void setInmueble_clase(Integer inmueble_clase) {
        this.inmueble_clase = inmueble_clase;
    }

    public String getInmueble_propietario() {
        return inmueble_propietario;
    }

    public void setInmueble_propietario(String inmueble_propietario) {
        this.inmueble_propietario = inmueble_propietario;
    }

    public String getInmueble_administrador() {
        return inmueble_administrador;
    }

    public void setInmueble_administrador(String inmueble_administrador) {
        this.inmueble_administrador = inmueble_administrador;
    }

    public String getInmueble_arrendatario() {
        return inmueble_arrendatario;
    }

    public void setInmueble_arrendatario(String inmueble_arrendatario) {
        this.inmueble_arrendatario = inmueble_arrendatario;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public Integer getComandante() {
        return comandante;
    }

    public void setComandante(Integer comandante) {
        this.comandante = comandante;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipoe() {
        return tipoe;
    }

    public void setTipoe(Integer tipoe) {
        this.tipoe = tipoe;
    }
    //Finalizacion de los Getters and Setters


    //Implementacion metodo ToString
    @Override
    public String toString() {
        return "Emergencia{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", informante=" + informante +
                ", informacion_recibida='" + informacion_recibida + '\'' +
                ", medio_informacion=" + medio_informacion +
                ", otro_medio_informacion='" + otro_medio_informacion + '\'' +
                ", persona_confirmacion='" + persona_confirmacion + '\'' +
                ", medio_confirmacion=" + medio_confirmacion +
                ", descripcion_otro_medio='" + descripcion_otro_medio + '\'' +
                ", direccion='" + direccion + '\'' +
                ", inmueble_clase=" + inmueble_clase +
                ", inmueble_propietario='" + inmueble_propietario + '\'' +
                ", inmueble_administrador='" + inmueble_administrador + '\'' +
                ", inmueble_arrendatario='" + inmueble_arrendatario + '\'' +
                ", novedades='" + novedades + '\'' +
                ", comandante=" + comandante +
                ", estado=" + estado +
                ", tipoe=" + tipoe +
                '}';
    }

    public long insert(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put("eme_id",id);
        contentValues.put("eme_fecha",fecha.toString());
        contentValues.put("eme_hora",hora);
        contentValues.put("eme_informante",informante);
        contentValues.put("eme_informacion_recibida",informacion_recibida);
        contentValues.put("eme_medio_informacion",medio_informacion);
        contentValues.put("eme_descripcion_otro_medio",otro_medio_informacion);
        contentValues.put("eme_persona_confirmacion",persona_confirmacion);
        contentValues.put("eme_medio_confirmacion",medio_confirmacion);
        contentValues.put("eme_descripcion_otro_medio_c",descripcion_otro_medio);
        contentValues.put("eme_direccion",direccion);
        contentValues.put("eme_inmueble_clase",inmueble_clase);
        contentValues.put("eme_inmueble_propietario",inmueble_propietario);
        contentValues.put("eme_inmueble_administrador",inmueble_administrador);
        contentValues.put("eme_inmueble_arrendatario",inmueble_arrendatario);
        contentValues.put("eme_novedades",novedades);
        contentValues.put("eme_comandante",comandante);
        contentValues.put("eme_estado",estado);
        contentValues.put("eme_tipoe",tipoe);
        return db.insert("emergencia",null,contentValues);

    }

    public int update(SQLiteDatabase db, Integer codigoOriginal){

        ContentValues contentValues = new ContentValues();
        contentValues.put("eme_id",id);
        contentValues.put("eme_fecha",fecha.toString());
        contentValues.put("eme_hora",hora);
        contentValues.put("eme_informante",informante);
        contentValues.put("eme_informacion_recibida",informacion_recibida);
        contentValues.put("eme_medio_informacion",medio_informacion);
        contentValues.put("eme_descripcion_otro_medio",otro_medio_informacion);
        contentValues.put("eme_persona_confirmacion",persona_confirmacion);
        contentValues.put("eme_medio_confirmacion",medio_confirmacion);
        contentValues.put("eme_descripcion_otro_medio_c",descripcion_otro_medio);
        contentValues.put("eme_direccion",direccion);
        contentValues.put("eme_inmueble_clase",inmueble_clase);
        contentValues.put("eme_inmueble_propietario",inmueble_propietario);
        contentValues.put("eme_inmueble_administrador",inmueble_administrador);
        contentValues.put("eme_inmueble_arrendatario",inmueble_arrendatario);
        contentValues.put("eme_novedades",novedades);
        contentValues.put("eme_comandante",comandante);
        contentValues.put("eme_estado",estado);
        contentValues.put("eme_tipoe",tipoe);
        System.out.println("Codigo Original "+codigoOriginal);
        String params[] = new String[]{codigoOriginal.toString()};
        return db.update("emergencia",contentValues,"eme_id=?",params);

    }

    public int remove(SQLiteDatabase db){

        String[] args = new String[]{id.toString()};
        int result = db.delete("emergencia","eme_id=?",args);
        return result;

    }

}
