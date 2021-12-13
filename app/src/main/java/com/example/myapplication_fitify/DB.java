package com.example.myapplication_fitify;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Exercitii.class}, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {
    public abstract ExercitiiDAO exercitiiDAO();
    public static DB instance;

    public static DB getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, DB.class, "Exercitii").build();
        }
        return instance;
    }
}
