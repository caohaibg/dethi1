package com.sie.dethi1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Sie on 5/8/2018.
 */

public class Database extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public static final String NAME="ocho";
    public static final String ID="id";
    public static final String TEN="ten";
    public static final String DIACHI="diachi";
    public static final String NAMSINH="namsinh";
    public static final String GENDER="gender";
    public static final String TRUONGYT="truongyt";

    public Database(Context context) {
        super(context, "ochover1.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE $s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", NAME, ID, TEN, DIACHI,GENDER, TRUONGYT));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(thisinhmodel ts){
        sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TEN, ts.getTen());
        contentValues.put(DIACHI, ts.getDiachi());
        contentValues.put(NAMSINH, ts.getNamsinh());
        contentValues.put(GENDER, ts.getGender());
        contentValues.put(TRUONGYT, ts.getTruongyt());

        sqLiteDatabase.insert(NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public final ArrayList<thisinhmodel> gedata(){

        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+NAME+";", null);

        ArrayList<thisinhmodel> list = new ArrayList<thisinhmodel>();
        while (cursor.moveToNext()){
            thisinhmodel ts = new thisinhmodel();
            ts.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            ts.setTen(cursor.getString(cursor.getColumnIndex(TEN)));
            ts.setDiachi(cursor.getString(cursor.getColumnIndex(DIACHI)));
            ts.setGender(cursor.getInt(cursor.getColumnIndex(GENDER)));
            ts.setTruongyt(cursor.getInt(cursor.getColumnIndex(TRUONGYT)));

            list.add(ts);
        }
        return list;
    }
}