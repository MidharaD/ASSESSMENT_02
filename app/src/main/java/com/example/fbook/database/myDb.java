package com.example.fbook.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;
import com.example.fbook.database.myDb;

public class myDb extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "faceBook.db";
    public static final String STUDENT_TABLE = "student";
    public static final String S_ID = "S_ID";
    public static final String S_NAME = "S_NAME";
    public static final String S_AGE = "S_AGE";
    public static final String S_MARKS = "S_MARKS";


    public myDb(Context context1, String dbName, @Nullable Context context, int dbVersion) {
       super(context, DB_NAME,null, DB_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: " + "database create successfully...");
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + "(S_ID INTEGER PRIMARY KEY AUTOINCREMENT, S_NAME TEXT, S_AGE INTEGER, S_MARKS INTEGER)");
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onCreate: " + "database update successfully...");
        db.execSQL("DROP TABLE IF EXISTS" + STUDENT_TABLE);
        onCreate(db);
    }
    public boolean insertstudent(String Name, String Age, String Marks) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues conValues = new ContentValues();
        conValues.put(S_NAME, Name);
        conValues.put(S_AGE, Age);
        conValues.put(S_MARKS, Marks);

        Long insertRESULT = db.insert(STUDENT_TABLE, null, conValues);
        db.close();
        if (insertRESULT == -1) {
            return false;
        } else {
            return true;
        }
    }
    
}
