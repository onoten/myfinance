package com.ad.core.io;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.core.entity.EUsuario;
import com.ad.core.entity.Ecuenta;

import java.util.List;

@Dao
public interface DaoUsuario {
    @Insert
    void insertAll(EUsuario... usuarios);

    @Query("SELECT * FROM tbusuario")
    List<EUsuario> getAll();

    @Update
    void update(EUsuario usuario);
    @Delete
    void delete(EUsuario usuario);
}
