package com.s4.demodb.db.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eljoeborja on enero 24 de 2015
 */
public class Vehiculo implements Serializable{

    private Integer vehId;
    private String vehClase;
    private String vehPlaca;
    private String vehModelo;
    private String vehPropietario;
    private String vehSoat;
    private String vehServicio;
    private String vehMarca;
    private String vehEmpresa;
    private String vehConductor;
    private String vehCompaniaSeguro;
    private Integer vehEstado;

    public Integer getVehId() {
        return vehId;
    }

    public void setVehId(Integer id) {
        this.vehId = id;
    }

    public String getVehClase() {
        return vehClase;
    }

    public void setVehClase(String vehClase) {
        this.vehClase = vehClase;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getVehPropietario() {
        return vehPropietario;
    }

    public void setVehPropietario(String vehPropietario) {
        this.vehPropietario = vehPropietario;
    }

    public String getVehSoat() {
        return vehSoat;
    }

    public void setVehSoat(String vehSoat) {
        this.vehSoat = vehSoat;
    }

    public String getVehServicio() {
        return vehServicio;
    }

    public void setVehServicio(String vehServicio) {
        this.vehServicio = vehServicio;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public String getVehEmpresa() {
        return vehEmpresa;
    }

    public void setVehEmpresa(String vehEmpresa) {
        this.vehEmpresa = vehEmpresa;
    }

    public String getVehConductor() {
        return vehConductor;
    }

    public void setVehConductor(String vehConductor) {
        this.vehConductor = vehConductor;
    }

    public String getVehCompaniaSeguro() {
        return vehCompaniaSeguro;
    }

    public void setVehCompaniaSeguro(String vehCompaniaSeguro) {
        this.vehCompaniaSeguro = vehCompaniaSeguro;
    }
    public Integer getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(Integer vehEstado) {
        this.vehEstado = vehEstado;
    }

    public Vehiculo(Integer id, String veh_clase, String vehPlaca, String vehModelo, String veh_propietario, String vehSoat, String vehServicio, String veh_marca, String veh_empresa, String vehConductor, String vehCompaniaSeguro, Integer veh_estado) {
        this.vehId = id;
        this.vehClase = veh_clase;
        this.vehPlaca = vehPlaca;
        this.vehModelo = vehModelo;
        this.vehPropietario = veh_propietario;
        this.vehSoat = vehSoat;
        this.vehServicio = vehServicio;
        this.vehMarca = veh_marca;
        this.vehEmpresa = veh_empresa;
        this.vehConductor = vehConductor;
        this.vehCompaniaSeguro = vehCompaniaSeguro;
        this.vehEstado = veh_estado;
    }

    @Override
    public String toString() {
        return "vehiculo{" +
                "veh_id=" + vehId +
                '}';
    }

    public long insert(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put("veh_id",vehId);
        contentValues.put("veh_clase", vehClase);
        contentValues.put("veh_placa", vehPlaca);
        contentValues.put("veh_modelo", vehModelo);
        contentValues.put("veh_propietario", vehPropietario);
        contentValues.put("veh_soat", vehSoat);
        contentValues.put("veh_servicio", vehServicio);
        contentValues.put("veh_marca", vehMarca);
        contentValues.put("veh_empresa", vehEmpresa);
        contentValues.put("veh_conductor", vehConductor);
        contentValues.put("veh_compania_seguro", vehCompaniaSeguro);
        contentValues.put("veh_estado",vehEstado);
        return db.insert("vehiculo",null,contentValues);

    }

    public int update(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put("veh_id",vehId);
        contentValues.put("veh_clase", vehClase);
        contentValues.put("veh_placa", vehPlaca);
        contentValues.put("veh_modelo", vehModelo);
        contentValues.put("veh_propietario", vehPropietario);
        contentValues.put("veh_soat", vehSoat);
        contentValues.put("veh_servicio", vehServicio);
        contentValues.put("veh_marca", vehMarca);
        contentValues.put("veh_empresa", vehEmpresa);
        contentValues.put("veh_conductor", vehConductor);
        contentValues.put("veh_compania_seguro", vehCompaniaSeguro);
        contentValues.put("veh_estado",vehEstado);
        System.out.println("Codigo Original "+vehId);
        String params[] = new String[]{vehId.toString()};
        return db.update("vehiculo",contentValues,"veh_id=?",params);

    }

    public int remove(SQLiteDatabase db){

        String[] args = new String[]{vehId.toString()};
        int result = db.delete("vehiculo","veh_id=?",args);
        return result;

    }

    /**
     * Consultar la lista de vehiculos dentro de la base de datos
     * @param db base de datos en modo lectura
     * @param todos si es verdadero, me retorna todos los vehiculos, sino solo los que se editaron o crearon
     * @return listado de vehiculos
     */
    public static List<Vehiculo> getList(SQLiteDatabase db, boolean todos){

        String where = null;
        String[] params = null;
        if(!todos){
            where = "veh_estado = ?";
            params = new String[]{"0"};
        }

        Cursor c = db.query("vehiculo", null, where, params, null, null, null);

        List<Vehiculo> vehiculos = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                Integer id = Integer.parseInt(c.getString(0));
                String clase = c.getString(1);
                String placa = c.getString(2);
                String modelo = c.getString(3);
                String propietario = c.getString(4);
                String soat = c.getString(5);
                String servicio = c.getString(6);
                String marca = c.getString(7);
                String empresa = c.getString(8);
                String conductor = c.getString(9);
                String compania_seguro = c.getString(10);
                Integer veh_estado = Integer.parseInt(c.getString(11));
                System.out.println("Id = "+id+" - Clase = "+clase+" - Placa = "+placa+" - Modelo = "+modelo+" - Propietario = "+propietario+" - Soat = "+soat);
                System.out.println("Servicio = "+servicio+" - Marca = "+marca+" - Empresa = "+empresa+" - Conductor = "+conductor+" - Compañia de Seguro = "+compania_seguro+" - Estado = "+veh_estado);
                Vehiculo vehiculo = new Vehiculo(id,clase,placa,modelo,propietario,soat,servicio,marca,empresa,conductor,compania_seguro,veh_estado);
                vehiculos.add(vehiculo);
            }while (c.moveToNext());
        }

        return vehiculos;

    }

}
