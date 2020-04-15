package com.example.tt;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Jobs.class }, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract JobsDao JobsDao();
}
//,exportSchema = false