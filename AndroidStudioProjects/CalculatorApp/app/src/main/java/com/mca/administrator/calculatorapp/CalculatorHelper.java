package com.mca.administrator.calculatorapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class CalculatorHelper extends SQLiteOpenHelper {
    public static final String Dbname = "CalDb.db";
    public static final String TableName = "calculator";
    public static final String col1 = "id";
    public static final String col2 = "number1";
    public static final String col3 = "number2";
    public static final String col4 = "Result";

    public CalculatorHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String number1, String number2, String Result) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, number1);
        contentValues.put(col3, number2);
        contentValues.put(col4, Result);
        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }
}