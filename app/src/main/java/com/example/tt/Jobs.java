package com.example.tt;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Jobs {
    @PrimaryKey( autoGenerate = true)
    public int idd ;


    public String title;


    public String companyLogo;
}
