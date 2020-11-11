package com.example.swedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Time;

public class Database extends SQLiteOpenHelper {

public static final String DB_Name="SWE.db";
public static final int DB_version=3;
public static final String eventTable="event";
public static final String eventTitle="title";
public static final String eventDate="date";
public static final String eventTime="time";
public static final String eventLocation="location";
public static final String eventtype="eventType";
public static final String eventDescription="description";

public Database(Context cont){

    super(cont, DB_Name, null, DB_version);
}



    @Override

    // call this method when create the database
    //this method only execute one time (when you start run the code only)
    /*so if you want to add a new column you should write SQL code(delete table) inside onUpgrade method
         then write SQL code(create table) with your update. */
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //create table on database
        String CreateTableStatment="CREATE TABLE " +eventTable + " (" +eventTitle + " varchar PRIMARY KEY, "+ eventDate + " INT, "+ eventTime + " INT, "+ eventLocation + " TEXT, "+ eventtype + " TEXT, "+ eventDescription + " TEXT )";
        sqLiteDatabase.execSQL(CreateTableStatment);
    }

    @Override

    // call this method when you want to update the database
    //It is called in the event that the version is changed to a new version
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS event");onCreate(sqLiteDatabase);
        //any change on event the code should be here!

    }

    //add event to db
public boolean addEvent(Event event){


    SQLiteDatabase db =this.getWritableDatabase();

    ContentValues values=new ContentValues();

    values.put(eventTitle,event.getTitle());
    values.put(eventDate,event.getDate());
    values.put(eventTime,event.getTime());
    values.put(eventLocation,event.getLocation());
    values.put(eventtype,event.getEventType());
    values.put(eventDescription,event.getDescription());



   long result= db.insert(eventTable,null,values);

   if(result==-1)
       return false;
  return true;

}

}
