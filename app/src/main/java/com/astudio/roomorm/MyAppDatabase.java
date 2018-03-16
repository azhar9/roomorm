package com.astudio.roomorm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Azhar Syed on 15-03-2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
