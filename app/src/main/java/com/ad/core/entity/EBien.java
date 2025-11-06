package com.ad.core.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "catbienservicio")
public class EBien {

    @PrimaryKey(autoGenerate = true)
    private int biensvid;
    @ColumnInfo
    private String bien;

    @ColumnInfo
    private String emailfk;

    @Ignore
    private List<EProducto> productos;

    public EBien() {    }

    public EBien(int biensvid, String bien) {
        this.biensvid = biensvid;
        this.bien = bien;
    }

    public int getBiensvid() {
        return biensvid;
    }

    public void setBiensvid(int biensvid) {
        this.biensvid = biensvid;
    }

    public String getBien() {
        return bien;
    }

    public void setBien(String bien) {
        this.bien = bien;
    }

    public List<EProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<EProducto> productos) {
        this.productos = productos;
    }

    public String getEmailfk() {
        return emailfk;
    }

    public void setEmailfk(String emailfk) {
        this.emailfk = emailfk;
    }
}
