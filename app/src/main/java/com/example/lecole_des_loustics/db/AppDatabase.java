package com.example.lecole_des_loustics.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, QuestGeo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDao();

    public abstract  GeographieDAO geographieDAO();

}
