package com.s4.demodb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Created by gurzaf on 1/6/15.
 */
public class UsuariosDBOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "dbusuarios";
    private String query1 = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT, contrasena TEXT)";
    private String query2 ="CREATE TABLE departamento (dep_codigo INTEGER (2) PRIMARY KEY, dep_nombre VARCHAR (50))";
    private String query3 ="CREATE TABLE municipio (mun_id INTEGER (3) PRIMARY KEY, mun_dep_codigo INTEGER (2) REFERENCES departamento (dep_codigo) ON DELETE RESTRICT ON UPDATE RESTRICT, mun_codigo INTEGER (3), mun_nombre VARCHAR (50))";
    private String query4 ="CREATE TABLE aseguradora (ase_nit VARCHAR (15) PRIMARY KEY, ase_razon_social VARCHAR (100) NOT NULL, ase_mun_id INTEGER (3) REFERENCES municipio (mun_id) ON DELETE RESTRICT ON UPDATE RESTRICT, ase_direccion VARCHAR (100) NOT NULL, ase_telefono VARCHAR (50) NOT NULL, ase_fax VARCHAR (25) NOT NULL, ase_email VARCHAR (50) NOT NULL, ase_pagina_web VARCHAR (50) NOT NULL)";
    private String query5 ="CREATE TABLE maquina (maq_id INTEGER PRIMARY KEY, maq_descripcion VARCHAR (30) NOT NULL, maq_estado_func INT (1) NOT NULL, maq_estado INT (1) NOT NULL)";
    private String query6 ="CREATE TABLE vehiculo (veh_id INTEGER PRIMARY KEY AUTOINCREMENT, veh_clase VARCHAR (30) NOT NULL DEFAULT ('faltante'), veh_placa VARCHAR (10) NOT NULL DEFAULT ('faltante'), veh_modelo VARCHAR (4) NOT NULL DEFAULT ('no'), veh_propietario VARCHAR (50) NOT NULL DEFAULT ('faltante'), veh_soat VARCHAR (30) NOT NULL DEFAULT ('faltante'), veh_servicio VARCHAR (30) NOT NULL DEFAULT ('faltante'), veh_marca VARCHAR (30) NOT NULL DEFAULT ('faltante'), veh_empresa VARCHAR (50) NOT NULL DEFAULT ('faltante'), veh_conductor VARCHAR (50) NOT NULL DEFAULT ('faltante'), veh_compania_seguro VARCHAR (50) NOT NULL DEFAULT ('faltante'), veh_estado INT (1) NOT NULL)";
    private String query7 ="CREATE TABLE persona (per_id INTEGER PRIMARY KEY AUTOINCREMENT, per_cedula VARCHAR (50) DEFAULT ('faltante') NOT NULL, per_apellidos VARCHAR (50) NOT NULL DEFAULT ('faltante'), per_nombres VARCHAR (50) NOT NULL DEFAULT ('faltante'), per_municipio INTEGER (3) REFERENCES municipio (mun_id) ON DELETE RESTRICT ON UPDATE RESTRICT, per_direccion VARCHAR (70) NOT NULL DEFAULT ('faltante'), per_telefono VARCHAR (30) NOT NULL DEFAULT ('faltante'), per_tipo INT (1) NOT NULL, per_fechanac DATE, per_estado INT (1) NOT NULL)";
    private String query8 ="CREATE TABLE unidad (uni_npib VARCHAR (10) NOT NULL PRIMARY KEY, uni_cbv VARCHAR (70) NOT NULL, uni_rango VARCHAR (30) NOT NULL, uni_gsrh VARCHAR (3) NOT NULL, uni_per_id INTEGER NOT NULL REFERENCES persona (per_id) ON DELETE CASCADE ON UPDATE CASCADE, uni_maquinista CHAR (1) NOT NULL DEFAULT (0), uni_estado INT (1) NOT NULL)";
    private String query9 ="CREATE TABLE usuario (usu_id INTEGER PRIMARY KEY, usu_name VARCHAR (10) NOT NULL, usu_password VARCHAR (10) NOT NULL, usu_npib VARCHAR (10) NOT NULL REFERENCES unidad (uni_npib) ON DELETE CASCADE ON UPDATE CASCADE UNIQUE)";
    private String query10 ="CREATE TABLE material (mat_id INTEGER PRIMARY KEY, mat_descripcion VARCHAR (30) NOT NULL, mat_tipo CHAR (2) NOT NULL, mat_estado INT (1) NOT NULL)";
    private String query11 ="CREATE TABLE emergencia (eme_id INTEGER PRIMARY KEY AUTOINCREMENT, eme_fecha DATE NOT NULL, eme_hora TIME NOT NULL, eme_informante INTEGER REFERENCES persona (per_id) ON DELETE RESTRICT ON UPDATE RESTRICT, eme_informacion_recibida VARCHAR NOT NULL DEFAULT ('ninguna'), eme_medio_informacion INT, eme_descripcion_otro_medio VARCHAR, eme_persona_confirmacion VARCHAR, eme_medio_confirmacion INT, eme_descripcion_otro_medio_c VARCHAR, eme_direccion VARCHAR, eme_inmueble_clase INT, eme_inmueble_propietario VARCHAR, eme_inmueble_administrador VARCHAR, eme_inmueble_arrendatario VARCHAR, eme_novedades VARCHAR NOT NULL DEFAULT ('ninguna'), eme_comandante VARCHAR REFERENCES unidad (uni_npib) ON DELETE RESTRICT ON UPDATE RESTRICT, eme_estado INT (1) NOT NULL, eme_tipoe INT)";
    private String query12 ="CREATE TABLE maquina_emergencia (maq_eme_id INTEGER PRIMARY KEY AUTOINCREMENT, maq_eme_eme INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT, maq_eme_maq INTEGER REFERENCES maquina (maq_id) ON DELETE RESTRICT ON UPDATE RESTRICT, maq_eme_npib VARCHAR REFERENCES unidad (uni_npib) ON DELETE RESTRICT ON UPDATE RESTRICT, maq_eme_fecha_salida DATE NOT NULL, maq_eme_hora_salida TIME NOT NULL, maq_eme_unidades INT NOT NULL, maq_eme_fecha_regreso DATE NOT NULL, maq_eme_hora_regreso TIME NOT NULL, maq_eme_estado INT (1) NOT NULL)";
    private String query13 ="CREATE TABLE material_utilizado (mat_uti_id INTEGER PRIMARY KEY AUTOINCREMENT, mat_uti_mat INTEGER REFERENCES material (mat_id) ON DELETE RESTRICT ON UPDATE RESTRICT, mat_uti_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT, mat_uti_cant INTEGER NOT NULL DEFAULT (1), mat_uti_estado INT (1) NOT NULL)";
    private String query14 ="CREATE TABLE incendio_estructural (ince_id INTEGER PRIMARY KEY AUTOINCREMENT, ince_danosm VARCHAR (250), ince_inmueble VARCHAR (250), ince_muebles VARCHAR (250), ince_can_afectadas INT (3) NOT NULL, ince_observaciones TEXT (0), ince_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query15 ="CREATE TABLE incendio_forestal (incf_id INTEGER PRIMARY KEY AUTOINCREMENT, incf_area VARCHAR (20) NOT NULL, incf_tipo_area INT NOT NULL, incf_otro VARCHAR (50, 0), incf_can_afectados INT (3) NOT NULL, incf_observaciones TEXT, incf_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query16 ="CREATE TABLE inundacion (inu_id INTEGER PRIMARY KEY AUTOINCREMENT, inu_area NUMERIC (4, 2) NOT NULL, inu_danos TEXT NOT NULL, inu_cant_inmuebles INT (3), inu_muebles TEXT, inu_cant_afectados INT (3) NOT NULL, \"inu_observaciones-\" TEXT, inu_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE NO ACTION ON UPDATE NO ACTION)";
    private String query17 ="CREATE TABLE otros_incidentes (otr_id INTEGER PRIMARY KEY AUTOINCREMENT, otr_clase_incidente VARCHAR (100) NOT NULL, otr_danos TEXT NOT NULL, otr_inmueble INT (3), otr_muebles TEXT, otr_cant_afectados INT (3), otr_observaciones TEXT, otr_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query18 ="CREATE TABLE personal_emergencia (pereme_id INTEGER PRIMARY KEY AUTOINCREMENT, pereme_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT, pereme_npib VARCHAR REFERENCES unidad (uni_npib) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query19 ="CREATE TABLE costo (costo_id INTEGER PRIMARY KEY AUTOINCREMENT, costo_combustible DOUBLE NOT NULL, costo_galones REAL, costo_alimentos DOUBLE, costo_danos DOUBLE, costo_otrosdes TEXT, costo_otros DOUBLE, costo_total DOUBLE NOT NULL, costo_observaciones TEXT, costo_eme_id INTEGER REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query20 ="CREATE TABLE accidente_transito (acc_id INTEGER PRIMARY KEY AUTOINCREMENT, acc_descripcion TEXT NOT NULL, acc_colision_obj_mov BOOLEAN NOT NULL, acc_colision_obj_fijo BOOLEAN, acc_volcamiento BOOLEAN, acc_peaton_atropellado BOOLEAN, acc_ciclista_atropellado BOOLEAN, acc_descripcion_otros TEXT, acc_eme_id VARCHAR REFERENCES emergencia (eme_id) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query21 ="CREATE TABLE vehiculo_comprometido (vehcom_id INTEGER PRIMARY KEY AUTOINCREMENT, vehcom_acc_id INTEGER REFERENCES accidente_transito (acc_id) ON DELETE RESTRICT ON UPDATE RESTRICT, vehcom_veh_id INTEGER REFERENCES vehiculo (veh_id) ON DELETE RESTRICT ON UPDATE RESTRICT)";
    private String query22 ="CREATE TABLE victima_accidente (vic_id INTEGER PRIMARY KEY AUTOINCREMENT, vic_per_id INTEGER REFERENCES persona (per_id) ON DELETE RESTRICT ON UPDATE RESTRICT, vic_acc_id INTEGER REFERENCES accidente_transito (acc_id) ON DELETE RESTRICT ON UPDATE RESTRICT, vic_estado BOOLEAN NOT NULL)";

    public UsuariosDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);
        db.execSQL(query7);
        db.execSQL(query8);
        db.execSQL(query9);
        db.execSQL(query10);
        db.execSQL(query11);
        db.execSQL(query12);
        db.execSQL(query13);
        db.execSQL(query14);
        db.execSQL(query15);
        db.execSQL(query16);
        db.execSQL(query17);
        db.execSQL(query18);
        db.execSQL(query19);
        db.execSQL(query20);
        db.execSQL(query21);
        db.execSQL(query22);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS departamento");
        db.execSQL("DROP TABLE IF EXISTS municipio");
        db.execSQL("DROP TABLE IF EXISTS aseguradora");
        db.execSQL("DROP TABLE IF EXISTS maquina");
        db.execSQL("DROP TABLE IF EXISTS vehiculo");
        db.execSQL("DROP TABLE IF EXISTS persona");
        db.execSQL("DROP TABLE IF EXISTS unidad");
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS material");
        db.execSQL("DROP TABLE IF EXISTS emergencia");
        db.execSQL("DROP TABLE IF EXISTS maquina_emergencia");
        db.execSQL("DROP TABLE IF EXISTS material_utilizado");
        db.execSQL("DROP TABLE IF EXISTS incendio_estructural");
        db.execSQL("DROP TABLE IF EXISTS incendio_forestal");
        db.execSQL("DROP TABLE IF EXISTS inundacion");
        db.execSQL("DROP TABLE IF EXISTS otros_incidentes");
        db.execSQL("DROP TABLE IF EXISTS personal_emergencia");
        db.execSQL("DROP TABLE IF EXISTS costo");
        db.execSQL("DROP TABLE IF EXISTS accidente_transito");
        db.execSQL("DROP TABLE IF EXISTS vehiculo_comprometido");
        db.execSQL("DROP TABLE IF EXISTS victima_accidente");
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);
        db.execSQL(query7);
        db.execSQL(query8);
        db.execSQL(query9);
        db.execSQL(query10);
        db.execSQL(query11);
        db.execSQL(query12);
        db.execSQL(query13);
        db.execSQL(query14);
        db.execSQL(query15);
        db.execSQL(query16);
        db.execSQL(query17);
        db.execSQL(query18);
        db.execSQL(query19);
        db.execSQL(query20);
        db.execSQL(query21);
        db.execSQL(query22);
    }

    public static UsuariosDBOpenHelper getInstance(Context context){
        return new UsuariosDBOpenHelper(context,DB_NAME,null,5);
    }
}
