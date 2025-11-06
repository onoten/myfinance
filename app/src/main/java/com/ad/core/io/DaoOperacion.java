package com.ad.core.io;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.core.entity.EopType;

import java.util.List;

@Dao
public interface DaoOperacion {
    @Insert
    void insertAll(EopType... tipo);

    @Query("SELECT * FROM cattipoperacion")
    List<EopType> getAll();

    @Update
    void update(EopType tipo);
    @Delete
    void delete(EopType tipo);
}
