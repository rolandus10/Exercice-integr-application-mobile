package com.example.exercice_integre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class ProjetBDD {

    private static final int VERSION = 1;
    private static final String NOM_BDD = "projet.db";

    private static final String TABLE_PROJET = "Projet_Application_Mobile";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_ACTION = "ACTIONS";
    private static final int NUM_COL_ACTION = 1;
    private static final String COL_DATE = "DATE";
    private static final int NUM_COL_DATE = 2;
    private static final String COL_DUREE = "DUREE";
    private static final int NUM_COL_DUREE = 3;


    private SQLiteDatabase bdd;

    private ProjetBaseSQL projet;

    public ProjetBDD(Context context) {
        projet = new ProjetBaseSQL(context, NOM_BDD, null, VERSION);
    }

    public void openForWrite() {
        bdd = projet.getWritableDatabase();
    }

    public void openForRead() {
        bdd = projet.getReadableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public long inserProjet(Projet projet) {
        ContentValues content = new ContentValues();
        content.put(COL_ACTION, projet.getAction());
        content.put(COL_DATE, projet.getDate());
        content.put(COL_DUREE, projet.getDuree());

        return bdd.insert(TABLE_PROJET, null, content);
    }

    public int updateProject(int id, Projet projet) {
        ContentValues content = new ContentValues();
        content.put(COL_ACTION, projet.getAction());
        content.put(COL_DATE, projet.getDate());
        content.put(COL_DUREE, projet.getDuree());


        return bdd.update(TABLE_PROJET, content, COL_ID + " = " + id, null);
    }

    public int removeProject(int id) {
        return bdd.delete(TABLE_PROJET, COL_ID + " = " + id, null);
    }

    public Projet getProject(String name) {
        Cursor c = bdd.query(TABLE_PROJET, new String[] { COL_ID, COL_ACTION,
                        COL_DATE, COL_DUREE}, COL_ACTION + " LIKE \"" + name + "\"", null, null,
                null, COL_ACTION);
        return cursorToProject(c);
    }



    public Projet cursorToProject(Cursor c) {
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        Projet projet = new Projet();
        projet.setId(c.getInt(NUM_COL_ID));
        projet.setAction(c.getString(NUM_COL_ACTION));
        projet.setDate(c.getString(NUM_COL_DATE));
        projet.setDuree(c.getInt(NUM_COL_DUREE));

        c.close();
        return projet;
    }

    public ArrayList<Projet> getAllproject() {
        Cursor c = bdd.query(TABLE_PROJET, new String[] { COL_ID, COL_ACTION,
                COL_DATE,COL_DUREE}, null, null, null, null, COL_ACTION);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        ArrayList<Projet> projetList = new ArrayList<Projet> ();
        while (c.moveToNext()) {
            Projet projet = new Projet();
            projet.setId(c.getInt(NUM_COL_ID));
            projet.setAction(c.getString(NUM_COL_ACTION));
            projet.setDate(c.getString(NUM_COL_DATE));
            projet.setDuree(c.getInt(NUM_COL_DUREE));

            projetList.add(projet);
        }
        c.close();
        return projetList;
    }

    public String sum() {
        Cursor c = bdd.query(TABLE_PROJET, new String[] { COL_ID, COL_ACTION,
                COL_DATE,COL_DUREE}, null, null, null, null, COL_ACTION);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        Integer sum = 0;
        while (c.moveToNext()) {

            sum= sum +c.getInt(NUM_COL_DUREE);
        }
        c.close();
        return "total des heures = "+ sum;
    }

}
