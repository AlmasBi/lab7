package com.example.tt;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface JobsDao {
    @Insert
    void Insert(Jobs contact);
    @Update
    void Update(Jobs contact);
    @Delete
    void Delete(Jobs contact);
    @Query("SELECT * FROM Jobs")
    List<Jobs> getContact();
    @Query("SELECT * FROM Jobs WHERE idd = :id")
    Jobs getContactById(int id);

}
