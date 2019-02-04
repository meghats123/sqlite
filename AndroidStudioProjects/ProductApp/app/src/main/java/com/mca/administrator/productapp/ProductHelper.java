package com.mca.administrator.productapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class ProductHelper extends SQLiteOpenHelper {
    public static final String Dbname = "ProDb.db";
    public static final String TableName = "product";
    public static final String col1 = "id";
    public static final String col2 = "pmodel";
    public static final String col3 = "pcode";
    public static final String col4 = "pname";
    public static final String col5 = "psellername";
    public static final String col6 = "price";
    public static final String col7 = "Oname";
    public static final String col8 = "Omobileno";
    public static final String col9 = "brand";

    public ProductHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text," + col7 + " text," + col8 + " text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String pmodel, String pcode, String pname, String psellername, String price, String Oname, String Omobileno) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, pmodel);
        contentValues.put(col3, pcode);
        contentValues.put(col4, pname);
        contentValues.put(col5, psellername);
        contentValues.put(col6, price);
        contentValues.put(col7, Oname);
        contentValues.put(col8, Omobileno);

        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor SearchData(String pcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableName + " WHERE " + col3 + "='" + pcode + "'", null);
        return cursor;
    }

    public boolean UpdateData(String id, String pmodel, String pname, String psellername, String price, String Oname, String Omobileno) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, pmodel);
        contentValues.put(col4, pname);
        contentValues.put(col5, psellername);
        contentValues.put(col6, price);
        contentValues.put(col7, Oname);
        contentValues.put(col8, Omobileno);
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