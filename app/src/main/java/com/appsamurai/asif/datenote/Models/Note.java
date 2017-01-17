package com.appsamurai.asif.datenote.Models;

/**
 * Created by cennest on 1/17/17.
 */

public class Note {
    int _id;
    String _date;
    String _note;
    public Note(){   }

    public Note(int id, String date, String note){
        this._id = id;
        this._date = date;
        this._note = note;
    }

    public Note(String date, String note){
        this._date = date;
        this._note = note;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getDate(){
        return this._date;
    }

    public void setDate(String date){
        this._date = date;
    }

    public String getNote(){ return this._note; }

    public void setNote(String note){
        this._note = note;
    }
}
