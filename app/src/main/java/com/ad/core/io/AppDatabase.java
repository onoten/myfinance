package com.ad.core.io;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ad.core.entity.EBien;
import com.ad.core.entity.EOperacion;
import com.ad.core.entity.EProducto;
import com.ad.core.entity.EUsuario;
import com.ad.core.entity.Ecuenta;
import com.ad.core.entity.EopType;

@Database(entities = {Ecuenta.class, EOperacion.class, EopType.class, EUsuario.class,EBien.class, EProducto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DaoCuenta daoCuenta();
    public abstract DaoUsuario daoUsuario();
    public abstract DaoOperacion daoOperacion();
    public abstract DaoTipoOp daoTipoOp();
    public abstract DaoBienSv daoBienSv();
    public abstract DaoProducto daoProducto();
}
