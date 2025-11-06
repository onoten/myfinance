package com.ad.core.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tbusuario")
public class EUsuario {

    @PrimaryKey
    @NonNull
    private String email;
    @ColumnInfo
    private String nombre;

    @Ignore
    private List<Ecuenta> cuentas;

    public EUsuario(){}
    public EUsuario(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ecuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Ecuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
