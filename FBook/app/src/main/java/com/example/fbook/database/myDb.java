package com.example.fbook.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class myDb extends SQLiteOpenHelper {

    public static final String DB_NAME = "my_database_name";
    public static final int DB_VERSION = 1;

    private static final String student_table="student";
    private static final  String student_name="name";
    private static final  String student_age="age";
    private static final  String student_marks="marks";


    private static final String create_student_table=" CREATE TABLE "+student_table +"("+
            student_name+ " VARCHAR(120) ,"+
            student_age+" INTEGER ,"+
            student_marks+" INTEGER );";

      private static final String DROP_TABLE=" DROP TABLE IF EXISTS " + student_table;

      private static final String SELECT_STUDENT= "SELECT * FROM " + student_table;

    public myDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate: " + "database create successfully...");
        db.execSQL(create_student_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"onCreate: "+ "database update successfully...");
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }
public long insertstudent(String name,int age,int marks)
{
    SQLiteDatabase db = getWritableDatabase();
    db.execSQL("INSERT INTO "+ student_table+"VALUE('"+name+"',"+age+","+marks+")");
    db.close();
    return 0;
}
  public void getAllstudent(){
          SQLiteDatabase db =getWritableDatabase();
          Cursor cursor= db.rawQuery(SELECT_STUDENT,null);

          if (cursor.moveToFirst()){
              do {
                  Log.d(TAG,"getAllstudent:" +
                          "Name :" + cursor.getString((cursor.getColumnIndex(student_name)))+
                          "AGE :" + cursor.getInt(cursor.getColumnIndex(student_age))+
                          "Marks :" + cursor.getInt(cursor.getColumnIndex(student_marks)));
              }while (cursor.moveToNext());
          }
  }
}
