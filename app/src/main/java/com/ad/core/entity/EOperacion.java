package com.ad.core.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tboperacion")
public class EOperacion {
    @PrimaryKey(autoGenerate = true)
    private int operacionid;
    @ColumnInfo(name = "origenfk")
    private int cuentaorigenfk;
    @ColumnInfo(name = "destinofk")
    private int cuentadestinofk;
    @ColumnInfo
    private int tipoopfk;
    @ColumnInfo
    private int bienserviciofk;
    @ColumnInfo
    private int productofk;
    @ColumnInfo
    private Double saldo;
    @ColumnInfo
    private String usuariofk;

    public EOperacion(){}

    public int getOperacionid() {
        return operacionid;
    }

    public void setOperacionid(int operacionid) {
        this.operacionid = operacionid;
    }

    public int getCuentaorigenfk() {
        return cuentaorigenfk;
    }

    public void setCuentaorigenfk(int cuentaorigenfk) {
        this.cuentaorigenfk = cuentaorigenfk;
    }

    public int getCuentadestinofk() {
        return cuentadestinofk;
    }

    public void setCuentadestinofk(int cuentadestinofk) {
        this.cuentadestinofk = cuentadestinofk;
    }

    public int getTipoopfk() {
        return tipoopfk;
    }

    public void setTipoopfk(int tipoopfk) {
        this.tipoopfk = tipoopfk;
    }

    public int getBienserviciofk() {
        return bienserviciofk;
    }

    public void setBienserviciofk(int bienserviciofk) {
        this.bienserviciofk = bienserviciofk;
    }

    public int getProductofk() {
        return productofk;
    }

    public void setProductofk(int productofk) {
        this.productofk = productofk;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getUsuariofk() {
        return usuariofk;
    }

    public void setUsuariofk(String usuariofk) {
        this.usuariofk = usuariofk;
    }

    // operacoines db

    public int InsertOperacion(){
        if (cuentaorigenfk != 0 &&
         cuentadestinofk != 0 && tipoopfk != 0 &&
         bienserviciofk != 0 &&
         productofk != 0 &&
         !usuariofk.equals("")){
            //Si es transferencia activar para saldo update origen y update destino

            //insertar el registro a base de datos la operacion
            return 1; // todo sale bien
        }
        return -1;//hubo un error
    }
}
