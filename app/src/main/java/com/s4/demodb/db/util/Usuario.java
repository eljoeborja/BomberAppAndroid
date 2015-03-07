package com.s4.demodb.db.util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.s4.demodb.db.UsuariosDBOpenHelper;

import java.io.Serializable;

/**
 * Created by gurzaf on 1/6/15.
 */
public class Usuario implements Serializable{

    private String name;
    private String password;
    private Integer code;

    public Usuario(String name, String password, Integer code) {
        this.name = name;
        this.password = password;
        this.code = code;
    }

    public Usuario(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return code+" "+name;
    }
    public long insert(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo",code);
        contentValues.put("nombre",name);
        contentValues.put("contrasena",password);

        return db.insert("Usuarios",null,contentValues);

    }

    public int update(SQLiteDatabase db, Integer codigoOriginal){

        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo",code);
        contentValues.put("nombre",name);
        contentValues.put("contrasena",password);
        System.out.println("Codigo Original "+codigoOriginal);
        String params[] = new String[]{codigoOriginal.toString()};
        return db.update("Usuarios",contentValues,"codigo=?",params);

    }

    public int remove(SQLiteDatabase db){

        String[] args = new String[]{code.toString()};
        int result = db.delete("Usuarios","codigo=?",args);
        return result;

    }

}
