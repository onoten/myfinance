package com.ad.core.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tbcuenta")
public class Ecuenta {

    @PrimaryKey(autoGenerate = true)
    private int cuentaid;
    @ColumnInfo(name="clabe")
    private String clabe;
    @ColumnInfo(name="nombre")
    private String nombre;
    @ColumnInfo(name="saldo")
    private float saldo;

    @ColumnInfo(name="emailfk")
    private String email;

    @Ignore
    private List<EOperacion> operaciones;
    public Ecuenta(){}
    public Ecuenta(int id, String clabe, String nombre, float saldo,String email) {
        this.cuentaid = id;
        this.clabe = clabe;
        this.nombre = nombre;
        this.saldo = saldo;
        this.email = email;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public int getCuentaid() {
        return cuentaid;
    }

    public void setCuentaid(int cuentaid) {
        this.cuentaid = cuentaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int updateSaldo(float cantidad){
        if (this.saldo+cantidad > 0) {
            this.saldo = this.saldo + cantidad;
            //ACTUALIZAR DB
        }
        else
            return -1;
        return 1;
    }
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EOperacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<EOperacion> operaciones) {
        this.operaciones = operaciones;
    }

    public void addOperacion(EOperacion op){
        this.operaciones.add(op);
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre();
    }

}
