package com.ad.core.io;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.core.entity.EBien;

import java.util.List;

@Dao
public interface DaoBienSv {
    @Insert
    void insertAll(EBien... bienes);

    @Query("SELECT * FROM catbienservicio")
    List<EBien> getAll();

    @Query("SELECT * FROM catbienservicio WHERE emailfk = :emailUsuario")
    List<EBien> getByUsuario(String emailUsuario);

    @Update
    void update(EBien bien);
    @Delete
    void delete(EBien bien);
}
