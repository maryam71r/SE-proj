package com.example.se_proj;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DishDive.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_POSTS = "posts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMAGE_URL = "image_url";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_POSTS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_IMAGE_URL + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_USER_ID + " INTEGER, " +
                COLUMN_TIMESTAMP + " INTEGER" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades
    }
}