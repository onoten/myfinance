package com.ad.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbConexion extends SQLiteOpenHelper {

    public static final String DB_NAME = "misfinanzas";
    private static final int DB_VERSION =   2;
    public DbConexion(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // codigo sql
        db.execSQL(DbManager.TABLA_USUARIO_CREATE);
        db.execSQL(DbManager.TABLA_CUENTA_CREATE);
        db.execSQL(DbManager.TABLA_BIENSV_CREATE);
        db.execSQL(DbManager.TABLA_PRODUCTO_CREATE);
        db.execSQL(DbManager.TABLA_TIPOOPERACION_CREATE);
        db.execSQL(DbManager.TABLA_OPERACION_CREATE);
        db.execSQL(DbManager.USUARIO_BASE);
        db.execSQL(DbManager.TIPOS_OPERACION_BASE);
        db.execSQL(DbManager.BIEN_SV_BASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DbManager.TABLA_OPERACION_DROP);
        db.execSQL("DROP TABLE IF EXISTS tboperacion;");
        db.execSQL(DbManager.TABLA_TIPOOPERACION_DROP);
        db.execSQL("DROP TABLE IF EXISTS catproducto;");
        db.execSQL("DROP TABLE IF EXISTS catbienservicio;");
        db.execSQL(DbManager.TABLA_CUENTA_DROP);
        db.execSQL(DbManager.TABLA_USUARIO_DROP);
        onCreate(db);
    }
}
