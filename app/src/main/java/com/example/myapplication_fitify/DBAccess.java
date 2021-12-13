package com.example.myapplication_fitify;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import android.content.Context;

public class DBAccess {
    private Database database;


    private static DBAccess instance;

    public DBAccess(Context context1) {
    }

    public static DBAccess getInstance(Context context1){
        if(instance==null){
            instance=new DBAccess(context1);
        }
        return instance;
    }

    public Database getDatabase(){
        return database;
    }
}
