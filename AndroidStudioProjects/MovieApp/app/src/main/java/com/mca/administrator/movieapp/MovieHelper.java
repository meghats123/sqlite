package com.mca.administrator.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NavUtils;

/**
 * Created by Administrator on 1/30/2019.
 */
public class MovieHelper  extends SQLiteOpenHelper {
    public static final String Dbname = "MovieDb.db";
    public static final String TableName = "movie";
    public static final String col1 = "id";
    public static final String col2 = "Mname";
    public static final String col3 = "Mlanguage";
    public static final String col4 = "Mactor";
    public static final String col5 = "Mactress";
    public static final String col6 = "Ryear";
    public static final String col7 = "Director";
    public static final String col8 = "Producer";
    public static final String col9 = "Cameraman";
    public static final String col10 = "Tcollection";


    public MovieHelper(Context context) {
        super(context, Dbname, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," + col7 + " text," + col8 + " text," + col9 + " text," + col10 + " text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String Mname, String Mlanguage, String Mactor, String Mactress, String Ryear, String Director, String Producer, String Cameraman, String Tcollection) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, Mname);
        contentValues.put(col3, Mlanguage);
        contentValues.put(col4, Mactor);
        contentValues.put(col5, Mactress);
        contentValues.put(col6, Ryear);
        contentValues.put(col7, Director);
        contentValues.put(col8, Producer);
        contentValues.put(col9, Cameraman);
        contentValues.put(col10, Tcollection);

        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor SearchData(String Mname) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableName + " WHERE " + col2 + "='" + Mname + "'", null);
        return cursor;
    }

    public boolean UpdateData(String id, String Mlanguage, String Mactor, String Mactress, String Ryear, String Director, String Producer, String Cameraman, String Tcollection) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col3, Mlanguage);
        contentValues.put(col4, Mactor);
        contentValues.put(col5, Mactress);
        contentValues.put(col6, Ryear);
        contentValues.put(col7, Director);
        contentValues.put(col8, Producer);
        contentValues.put(col9, Cameraman);
        contentValues.put(col10, Tcollection);
        long status = sqLiteDatabase.update(TableName, contentValues, col1 + "=" + id, null);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean DeleteData(String id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long status = sqLiteDatabase.delete(TableName, col1 + "=" + id, null);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }
}