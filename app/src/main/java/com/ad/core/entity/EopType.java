package com.ad.core.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cattipoperacion")
public class EopType {
    @PrimaryKey(autoGenerate = true)
    private int operacionid;

    @ColumnInfo
    private String operacion;

    public EopType(){}

    public EopType(int operacionid, String operacion) {
        this.operacionid = operacionid;
        this.operacion = operacion;
    }

    public int getOperacionid() {
        return operacionid;
    }

    public void setOperacionid(int operacionid) {
        this.operacionid = operacionid;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
