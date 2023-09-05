package com.example.andymaster.DataBase;

import static com.example.andymaster.User_Dashboard.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.andymaster.Modelclasses.LoggedInUserModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@androidx.room.Database(entities = {
        LoggedInUserModel.class,
        UserModel.class,
        ChatMessage.class
}, version = 4  , exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static Database instance;
    private static final int NUMBER_OF_THREADS = 6;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract DbInterface dbInterface();

    public static synchronized Database getGetInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class,
                            DATABASE_NAME
                    )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}