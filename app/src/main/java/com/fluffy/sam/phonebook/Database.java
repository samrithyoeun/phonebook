package com.fluffy.sam.phonebook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Database extends SQLiteAssetHelper{

    private final static String DB_NAME = "contact.sqlite";
    private static  Database instance;

    public static Database Create(Context context){
        if(instance==null){
            instance = new Database(context);
        }
        return instance;
    }

    public Database(Context context) {
        super(context, DB_NAME,null,1);
    }

    public ArrayList<Contact> getData(){
        ArrayList<Contact> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cu = db.rawQuery("select * from tblPhoneBook order by logo",null);
        cu.moveToFirst();

        while(!cu.isAfterLast()){

            data.add(new Contact(
                    cu.getInt(0),
                    cu.getString(1),
                    cu.getString(2),
                    cu.getString(3),
                    cu.getString(4)
            ));


            cu.moveToNext();
        }
        Log.d("getCOunt",""+cu.getCount());

        return data;
    }


}
