package com.mlabs.bbm.firstandroidapp;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Hashtable;
    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.DatabaseUtils;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.database.sqlite.SQLiteDatabase;
    import android.util.Log;

    public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbAccounts.db";
    public static final String ACCOUNTS_TABLE_NAME = "accounts";
    public static final String ACCOUNTS_EMAIL = "email";
    public static final String ACCOUNTS_PASSWORD = "password";
    public static final String ACCOUNTS_DATE_CREATED = "date_created";
    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table accounts " +
                        "(email text primary key, password text,date_created text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertAccount(String email, String password,String created)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("date_created",created);
        db.insert("accounts", null, contentValues);
        return true;
    }

    public Cursor getData(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from accounts where email="+email+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, ACCOUNTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateAccounts(String email, String password, String created)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("date_created",created);
        db.update("accounts", contentValues, "email = ? ", new String[] { email } );
        return true;
    }

    public ArrayList<String> getAllAccounts()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from accounts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(ACCOUNTS_EMAIL)));
            res.moveToNext();
        }
        return array_list;
    }

    public String validateUser(String username, String password)
    {
        String selectQuery = "SELECT * FROM " + ACCOUNTS_TABLE_NAME + " WHERE " + ACCOUNTS_PASSWORD + " = '" + password + "' AND " + ACCOUNTS_EMAIL + " = '" +username+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0)
        {
            cursor.close();
            db.close();
            return "True";
        }
        cursor.close();
        db.close();
        return "False";
    }

}