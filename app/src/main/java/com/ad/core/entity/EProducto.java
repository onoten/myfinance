package com.ad.core.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EProducto {

    @PrimaryKey(autoGenerate = true)
    private int productoid;

    @ColumnInfo
    private String producto;

    @ColumnInfo
    private int biensvfk;

    public EProducto() {    }

    public EProducto(int productoid, String producto, int biensvfk) {
        this.productoid = productoid;
        this.producto = producto;
        this.biensvfk = biensvfk;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getBiensvfk() {
        return biensvfk;
    }

    public void setBiensvfk(int biensvfk) {
        this.biensvfk = biensvfk;
    }
}
