package com.example.elearningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelperJava extends SQLiteOpenHelper {

    static final String DATANAME="QuizJava.DB";
    static final int VERSION=1;


    public DataBaseHelperJava(@Nullable Context context) {
        super(context,DATANAME,null,VERSION);
        SQLiteDatabase db=getWritableDatabase();
    }
    static final String DATABSETABLE="JavaScore";


    private static final String CREATE="CREATE TABLE JavaScore( ID INTEGER PRIMARY KEY AUTOINCREMENT ,Correct INTEGER NOT NULL, Wrong INTEGER NOT NULL);";





    public long insertData(int Correct,int  Wrong){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Correct",Correct);
        contentValues.put("Wrong",Wrong);

        long data=db.insert(DATABSETABLE,null,contentValues);
        return data;
    }

    public Cursor getAll(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cur=db.rawQuery("SELECT * FROM "+DATABSETABLE.concat(" ORDER BY ID DESC"),null);

        return cur;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABSETABLE);

    }
}
