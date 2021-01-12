package com.example.proiectamdm;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "CovidTable.db";
    public static final String TABLE_NAME = "corona_virus";
    public static final String COL_ID = "id";
    public static final String COL_JUDET = "judet";
    public static final String COL_CAZURI_NOI = "cazuri_noi";
    public static final String COL_CAZURI_TOTALE = "cazuri_totale";
    public static final String COL_VACCINARI_NOI = "vaccinari_noi";
    public static final String COL_VACCINARI_TOTALE = "vaccinari_totale";
    int cazuri_totale = 0;
    int vaccinari_totale = 0;
    public DataBaseHelper(Context context) { super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_JUDET + " TEXT,"
                + COL_CAZURI_NOI + " INTEGER,"
                + COL_CAZURI_TOTALE + " INTEGER,"
                + COL_VACCINARI_NOI + " INTEGER,"
                + COL_VACCINARI_TOTALE + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


    public boolean insertData(String ps_judet, String pv_cazuri, String pv_vaccinuri)
    {
        cazuri_totale += Integer.parseInt(pv_cazuri);
        vaccinari_totale += Integer.parseInt(pv_vaccinuri);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_JUDET, ps_judet);
        values.put(COL_CAZURI_NOI, pv_cazuri);
        values.put(COL_CAZURI_TOTALE, cazuri_totale);
        values.put(COL_VACCINARI_NOI, pv_vaccinuri);
        values.put(COL_VACCINARI_TOTALE, vaccinari_totale);

        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(query, null);
        return result;
    }
}
