package com.example.exercice_integre;

public class Projet {
    private int id;
    private String date;
    private int duree;
    private  String action;


    public Projet(){}

    public Projet(int id, String date, int duree, String action) {
        this.id = id;
        this.date = date;
        this.duree = duree;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id+" "+"Action:" + action + "{" + "Date=" + date+" ").append(
                "Durée="+ duree + "}\n");
        return sb.toString();
    }
}
