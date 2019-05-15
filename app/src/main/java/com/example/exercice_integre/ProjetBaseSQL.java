package com.example.exercice_integre;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProjetBaseSQL extends SQLiteOpenHelper {

    private static final String TABLE_PROJET = "Projet_Application_Mobile";
    private static final String COL_ID = "ID";
    private static final String COL_ACTION = "ACTIONS";
    private static final String COL_DATE = "DATE";
    private static final String COL_DUREE = "DUREE";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_PROJET + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ACTION + " TEXT NOT NULL,"+
            COL_DATE  + " TEXT NOT NULL," + COL_DUREE + " INTEGER NOT NULL);";

    public ProjetBaseSQL(Context context, String action, SQLiteDatabase.CursorFactory factory, int version) {
        super (context, action, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_PROJET);
        onCreate(db);
    }

}