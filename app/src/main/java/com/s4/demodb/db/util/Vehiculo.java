package com.s4.demodb.db.util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;

/**
 * Created by eljoeborja on enero 24 de 2015
 */
public class Vehiculo implements Serializable{

    private Integer id;
    private String clase;
    private String placa;
    private String modelo;
    private String propietario;
    private String soat;
    private String servicio;
    private String marca;
    private String empresa;
    private String conductor;
    private String compania_seguro;
    private Integer veh_estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getCompania_seguro() {
        return compania_seguro;
    }

    public void setCompania_seguro(String compania_seguro) {
        this.compania_seguro = compania_seguro;
    }
    public Integer getVeh_estado() {
        return veh_estado;
    }

    public void setVeh_estado(Integer veh_estado) {
        this.veh_estado = veh_estado;
    }

    public Vehiculo(Integer id, String clase, String placa, String modelo, String propietario, String soat, String servicio, String marca, String empresa, String conductor, String compania_seguro, Integer veh_estado) {
        this.id = id;
        this.clase = clase;
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.soat = soat;
        this.servicio = servicio;
        this.marca = marca;
        this.empresa = empresa;
        this.conductor = conductor;
        this.compania_seguro = compania_seguro;
        this.veh_estado = veh_estado;
    }

    @Override
    public String toString() {
        return "vehiculo{" +
                "veh_id=" + id +
                '}';
    }

    public long insert(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put("veh_id",id);
        contentValues.put("veh_clase",clase);
        contentValues.put("veh_placa",placa);
        contentValues.put("veh_modelo",modelo);
        contentValues.put("veh_propietario",propietario);
        contentValues.put("veh_soat",soat);
        contentValues.put("veh_servicio",servicio);
        contentValues.put("veh_marca",marca);
        contentValues.put("veh_empresa",empresa);
        contentValues.put("veh_conductor",conductor);
        contentValues.put("veh_compania_seguro",compania_seguro);
        contentValues.put("veh_estado",veh_estado);
        return db.insert("vehiculo",null,contentValues);

    }

    public int update(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put("veh_id",id);
        contentValues.put("veh_clase",clase);
        contentValues.put("veh_placa",placa);
        contentValues.put("veh_modelo",modelo);
        contentValues.put("veh_propietario",propietario);
        contentValues.put("veh_soat",soat);
        contentValues.put("veh_servicio",servicio);
        contentValues.put("veh_marca",marca);
        contentValues.put("veh_empresa",empresa);
        contentValues.put("veh_conductor",conductor);
        contentValues.put("veh_compania_seguro",compania_seguro);
        contentValues.put("veh_estado",veh_estado);
        System.out.println("Codigo Original "+id);
        String params[] = new String[]{id.toString()};
        return db.update("vehiculo",contentValues,"veh_id=?",params);

    }

    public int remove(SQLiteDatabase db){

        String[] args = new String[]{id.toString()};
        int result = db.delete("vehiculo","veh_id=?",args);
        return result;

    }

}
