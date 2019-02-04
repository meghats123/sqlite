package com.mca.administrator.enquiryapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

/**
 * Created by Administrator on 1/30/2019.
 */
public class EnquiryHelper extends SQLiteOpenHelper {
    public static final String Dbname = "EnqDb.db";
    public static final String TableName = "enquiry";
    public static final String col1 = "id";
    public static final String col2 = "Name";
    public static final String col3 = "Emailid";
    public static final String col4 = "Mobileno";
    public static final String col5 = "Place";
    public static final String col6 = "purpose";
    public static final String col7 = "Message";

    public EnquiryHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," +col7+ "text )";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String Name, String Emailid, String Mobileno, String Place,String purpose, String Message) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, Name);
        contentValues.put(col3, Emailid);
        contentValues.put(col4, Mobileno);
        contentValues.put(col5, Place);
        contentValues.put(col6, purpose);

        contentValues.put(col7, Message);

        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor SearchData(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TableName+" WHERE "+col2+"='"+name+"'",null);
        return cursor;
    }
}