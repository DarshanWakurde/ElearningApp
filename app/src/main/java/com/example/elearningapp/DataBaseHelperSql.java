package com.example.elearningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelperSql extends SQLiteOpenHelper {




    static final String DATANAME="QuizSql" +
            ".DB";
    static final int VERSION=1;

    static final String DATABSETABLE="SqlScore";
    static final String USER_ID="_ID";
    static final String USER_NAME="user_name";
    static final String USER_PASSWORD="password";

    private static final String CREATE="CREATE TABLE SqlScore( ID INTEGER PRIMARY KEY AUTOINCREMENT ,Correct INTEGER NOT NULL, Wrong INTEGER NOT NULL);";

    public DataBaseHelperSql(@Nullable Context context) {
        super(context,DATANAME,null,VERSION);
        SQLiteDatabase db=getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABSETABLE);

    }

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
}
