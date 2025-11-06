package com.ad.core.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {
    public static final String TABLA_CUENTA = "tbcuenta";
    public static final String CUENTA_ID = "cuentaid";
    public static final String CUENTA_NOMBRE = "nombre";
    public static final double CUENTA_SALDO = 0.0;

    public static final String TABLA_USUARIO_CREATE = "CREATE TABLE tbusuario (email text primary key not null, nombre text);";
    public static final String TABLA_CUENTA_CREATE = "CREATE TABLE " + TABLA_CUENTA + " (cuentaid INTEGER primary key autoincrement, clabe TEXT, nombre TEXT, saldo REAL, emailfk text);";
    public static final String TABLA_TIPOOPERACION_CREATE = "CREATE TABLE cattipoperacion (operacionid integer primary key autoincrement, operacion text);";
    public static final String TABLA_OPERACION_CREATE = "CREATE TABLE tboperacion (operacionid integer primary key autoincrement, origenfk integer not null, destinofk integer not null, bienserviciofk integer not null, productofk integer not null,cantidad real,tipoopfk integer, usuariofk text not null);";
    public static final String TABLA_BIENSV_CREATE = "CREATE TABLE catbienservicio (biensvid INTEGER primary key autoincrement, bien text not null, emailfk TEXT not null);";
    public static final String TABLA_PRODUCTO_CREATE ="CREATE TABLE catproducto (productoid INTEGER primary key autoincrement, producto TEXT, biensvfk INTEGER);";
    public static final String TABLA_USUARIO_DROP = "DROP TABLE IF EXISTS tbusuario ;";
    public static final String TABLA_CUENTA_DROP = "DROP TABLE IF EXISTS " + TABLA_CUENTA + ";";
    public static final String TABLA_TIPOOPERACION_DROP = "DROP TABLE IF EXISTS cattipoperacion;";
    public static final String TABLA_OPERACION_DROP = "DROP TABLE IF EXISTS tboperacion;";

    public static final String USUARIO_BASE = "INSERT INTO TABLE tbusuario ('a@1','default');";
    public static final String TIPOS_OPERACION_BASE = "INSERT INTO TABLE cattipoperacion (operacion) values ('INGRESO'),('EGRESO'),('TRANSFERENCIA_INGRESO'),('TRANSFERENCIA_EGRESO')";
    public static final String BIEN_SV_BASE = "INSERT INTO TABLE catbienservicio (bien, emailfk) values ('B303','a@1'),('B105','a@1'),('Personal','a@1'),('RopaCalzado','a@1'),('Tarjeta','a@1'),('Salud','a@1'),('Transporte','a@1'),('Recreativos','a@1'),('Higiene','a@1'),('Otros','a@1');";

    private DbConexion conexion;
    private SQLiteDatabase db;

    public DbManager(Context context) {
        this.conexion = new DbConexion(context);
    }

    public DbManager open() throws SQLException{
        db = conexion.getWritableDatabase();
        return this;
    }

    public void close(){
        conexion.close();
    }

}
