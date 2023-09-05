package com.example.andymaster.DataBase;

import static com.example.andymaster.User_Dashboard.USERS_TABLE;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.checkerframework.checker.nullness.qual.NonNull;

@Entity(tableName = USERS_TABLE)
public class UserModel {
    @NonNull
    @PrimaryKey
    public int user_id = 0;

    public String name = "";
    public String phone_number = "";
    public String reg_date = "";
    public String last_seen = "";
    public String profile_photo = "";
}
