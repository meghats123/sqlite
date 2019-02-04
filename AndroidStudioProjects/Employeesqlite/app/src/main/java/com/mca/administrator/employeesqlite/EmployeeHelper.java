package com.mca.administrator.employeesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/29/2019.
 */
public class EmployeeHelper  extends SQLiteOpenHelper{
    public static final String Dbname="EmpDb.db";
    public static final String TableName="employee";
    public static final String col1="id";
    public static final String col2="empcode";
    public static final String col3="empname";
    public static final String col4="mobileno";
    public static final String col5="emailid";
    public static final String col6="designation";
    public static final String col7="salary";
    public static final String col8="companyname";

    public EmployeeHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table "+TableName+"("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text,"+col8+" text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+TableName;
        sqLiteDatabase.execSQL(query);
onCreate(sqLiteDatabase);
    }
    public boolean insertData(String empcode,String empname,String mobileno,String emailid,String designation,String salary,String companyname)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,empcode);
        contentValues.put(col3,empname);
        contentValues.put(col4,mobileno);
        contentValues.put(col5,emailid);
        contentValues.put(col6,designation);
        contentValues.put(col7,salary);
        contentValues.put(col8,companyname);
        long status=sqLiteDatabase.insert(TableName,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
