package com.tct.level4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import android.util.Log;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Aditya C Awalkar on 22-03-2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "apna";

    // Contacts table name
    private static final String TABLE_GCMBACKUP = "gcm";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_TIME = "time";
    private static final String KEY_MSG = "message";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GCMBACKUP_TABLE = "CREATE TABLE " + TABLE_GCMBACKUP + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TIME + " TEXT,"
                + KEY_MSG + " TEXT" + ")";
        db.execSQL(CREATE_GCMBACKUP_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GCMBACKUP);

        // Create tables again
        onCreate(db);
    }

    void add(String temp, String msg) {
        //String temp = t.toString();
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TIME, temp); // time when gcm msg is received
        values.put(KEY_MSG, msg); // the gcm msg

        db.insert(TABLE_GCMBACKUP, null, values);
        db.close();
    }


    public ArrayList displayAll() {
        ArrayList apnaList = new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_GCMBACKUP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToLast()) {
            do {
                int id= (Integer.parseInt(cursor.getString(0)));
                String timestamp= (cursor.getString(1));
                String msg= (cursor.getString(2));
                if(msg.equals(""))
                    msg= "<<<<<<<BUZZED>>>>>>>";
              /*  Timestamp t=Timestamp.valueOf(timestamp);

                Long te= t.getTime();       //yeh timestamp value millis mein dega
                Log.d("te",te.toString());
                Date d= new Date(te);

                String dateFormat = "dd/MM/yyyy HH:mm:ss";
                SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(te);
                String tt= formatter.format(calendar.getTime());

                Log.d("date", tt);
*/
                apnaList.add( "" + msg + "\n" +"" + timestamp );
               /* apnaList.add(timestamp);
                apnaList.add(msg);*/

            } while (cursor.moveToPrevious());
        }
       try {
           Object t = "";
           for (int i = 0; apnaList.listIterator().hasNext(); i++) {
               t = apnaList.get(i);
               Log.d("dbmsg", t.toString());
           }
       }
       catch(Exception e){e.printStackTrace();}
            return apnaList;
    }
}
