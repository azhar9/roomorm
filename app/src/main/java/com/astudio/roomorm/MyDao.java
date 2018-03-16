package com.astudio.roomorm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Azhar Syed on 15-03-2018.
 */

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void delete(User user);

    @Update
    public void updateUser(User user);


}
