package com.example.myapplication_fitify;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface ExercitiiDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Exercitii... ex);

    @Delete
    void delete(Exercitii ex);

    @Query("select * from Exercitii")
    List<Exercitii> getExercitii();

    @Query("SELECT * FROM Exercitii WHERE durata>10")
    List<Exercitii> getDurate();

}
