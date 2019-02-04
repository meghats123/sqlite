package com.mca.administrator.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/29/2019.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
   public static final String Dbname="MyDb.db";
   public static final String TableName="student";
   public static final String col1="id";
   public static final String col2="name";
   public static final String col3="email";
    
    public DatabaseHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+TableName+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
String query="drop table if exists "+TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String name,String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,email);
        long status=sqLiteDatabase.insert(TableName,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor SearchData(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TableName+" WHERE "+col2+"='"+name+"'",null);
        return cursor;
    }
    public boolean UpdateData(String id,String email)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col3,email);
        long status=sqLiteDatabase.update(TableName,contentValues,col1 +"=" +id,null);
        if (status==-1)
        {
            return false;
        }
        else {
            return true;

        }
    }
    public boolean DeleteData(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long status=sqLiteDatabase.delete(TableName,col1+"="+id,null);
        if (status==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
