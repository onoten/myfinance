package com.ad.core.io;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.core.entity.EOperacion;
import com.ad.core.entity.Ecuenta;

import java.util.List;

@Dao
public interface DaoTipoOp {
    @Insert
    void insertAll(EOperacion... operaciones);

    @Query("SELECT * FROM tboperacion")
    List<EOperacion> getAll();

    @Query("SELECT * FROM tboperacion WHERE origenfk = :cuentaOrigen")
    List<EOperacion> getByCuenta(int cuentaOrigen);

    @Update
    void update(EOperacion opn);
    @Delete
    void delete(EOperacion opn);
}
