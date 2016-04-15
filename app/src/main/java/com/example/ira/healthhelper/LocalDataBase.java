package com.example.ira.healthhelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLFeatureNotSupportedException;
import java.util.Vector;
import java.lang.String;

public class LocalDataBase extends SQLiteOpenHelper {
    private SQLiteDatabase mSqLiteDatabase;
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "myitems";
    private static final String ITEM_TABLE = "items";
    private static final String ITEM_NAME_COL = "item_name";
    private static final String ITEMS_TABLE_CREATE_SQL = "CREATE TABLE " + ITEM_TABLE + " ( " + ITEM_NAME_COL + " TEXT )";

    LocalDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mSqLiteDatabase = db;
        mSqLiteDatabase.execSQL(ITEMS_TABLE_CREATE_SQL);


        addSymptom("Нежить");
        addSymptom("Сухий кашель");
        addSymptom("Вологий кашель");
        addSymptom("Підвищена температура");
        addSymptom("Висока температура");
        addSymptom("Біль в горлі");
        addSymptom("Головний біль");
        addSymptom("Слабість");
        addSymptom("Задишка");
        addSymptom("Підвищений тиск");
        addSymptom("Понижений тиск");
        addSymptom("Почервоніння");
        addSymptom("Чхання");
        addSymptom("Нежить");
        addSymptom("Збільшені мигдалики");
        addSymptom("Висипка");
        addSymptom("Інтоксикація");
        addSymptom("Діарея");
        addSymptom("Нудота");
        addSymptom("Блювота");
        addSymptom("Лихоманка");
        addSymptom("Пітливість");
        addSymptom("Біль в серці");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: implement when several database versions are available
    }

    public long addSymptom(String item_name) {
        ContentValues values = new ContentValues();
        values.put(ITEM_NAME_COL, item_name);
        return mSqLiteDatabase.insert(ITEM_TABLE, null, values);
    }

    public Vector<String> getItems() {
        Vector<String> ret = new Vector<String>();

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + ITEM_TABLE, null);

        try {
            for (cursor.moveToFirst(); !cursor.isLast(); cursor.moveToNext()) {
                ret.add(new String(cursor.getString(0)));
            }
        } finally {
            cursor.close();
        }
        return ret;
    }

    public void deleteItem(String item_name) {
        getWritableDatabase().delete(ITEM_TABLE, ITEM_NAME_COL + " = ?", new String[]{item_name});
    }
}

