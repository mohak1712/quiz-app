package com.developervishalsehgal.udacityscholarsapp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Local database for the app. Contains only one database which all the related tables.
 * Notifications, Attempt Quiz, Create Quiz, Forums, Cache etc.
 *
 * TODO change the description after implementation
 *
 * @Author kaushald
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz_app.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
            QuestionContract.QuestionEntry.TABLE_NAME + " (" +
            QuestionContract.QuestionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            QuestionContract.QuestionEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
            QuestionContract.QuestionEntry.COLUMN_MARKS + " INTEGER NOT NULL," +
            QuestionContract.QuestionEntry.COLUMN_TYPE + " TEXT NOT NULL" +
            ");";

    private static final String CREATE_OPTIONS_TABLE = "CREATE TABLE " +
            OptionContract.OptionEntry.TABLE_NAME + " (" +
            OptionContract.OptionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            OptionContract.OptionEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
            OptionContract.OptionEntry.COLUMN_IS_CORRECT + " INTEGER NOT NULL," +
            OptionContract.OptionEntry.COLUMN_REMARKS + " TEXT," +
            OptionContract.OptionEntry.COLUMN_QUESTION_ID + " INTEGER NOT NULL," +
            "FOREIGN KEY("+ OptionContract.OptionEntry.COLUMN_QUESTION_ID+") REFERENCES " +
            QuestionContract.QuestionEntry.TABLE_NAME + "(" + QuestionContract.QuestionEntry._ID + ")" +
            ");";

    private static final String CREATE_FILES_TABLE = "CREATE TABLE " +
            FilesContract.FilesEntry.TABLE_NAME + " (" +
            FilesContract.FilesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FilesContract.FilesEntry.COLUMN_FILES_PATH + " TEXT NOT NULL," +
            FilesContract.FilesEntry.COLUMN_QUESTION_ID + " INTEGER NOT NULL," +
            "FOREIGN KEY("+ FilesContract.FilesEntry.COLUMN_QUESTION_ID+") REFERENCES " +
            QuestionContract.QuestionEntry.TABLE_NAME + "(" + QuestionContract.QuestionEntry._ID + ")" +
            ");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUESTIONS_TABLE);
        db.execSQL(CREATE_OPTIONS_TABLE);
        db.execSQL(CREATE_FILES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
