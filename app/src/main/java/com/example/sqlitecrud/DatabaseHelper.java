package com.example.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String STUDENT_NAME = "STUDENT_NAME";
    public static final String STUDENT_AGE = "STUDENT_AGE";
    public static final String STUDENT_COURSE = "STUDENT_COURSE";
    public static final String STUDENT_EMAIL = "STUDENT_EMAIL";
    public static final String STUDENT_TABLE = "STUDENT_TABLE";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " TEXT, " + STUDENT_AGE + " INT, " + STUDENT_COURSE + " TEXT, " + STUDENT_EMAIL + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



    }


    public boolean addOne(StudentModel studentModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(STUDENT_NAME,studentModel.getName());
        cv.put(STUDENT_AGE,studentModel.getAge());
        cv.put(STUDENT_COURSE,studentModel.getCourse());
        cv.put(STUDENT_EMAIL,studentModel.getEmail());

        db.insert(STUDENT_TABLE,null,cv);

        return true;
    }


    public List<StudentModel> getEveryone(){

        List<StudentModel> returnList = new ArrayList<>();
        //get data from database

        String queryString = "SELECT * FROM"+ STUDENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString);

        if(cursor.moveToFirst()){
            do{
                int STUDENT_ID = cursor.getInt(0);



            }while (cursor.moveToFirst());



        }
    }
}
