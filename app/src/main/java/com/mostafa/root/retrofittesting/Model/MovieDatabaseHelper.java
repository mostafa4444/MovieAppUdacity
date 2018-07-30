package com.mostafa.root.retrofittesting.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1 ;
    private static final String DATABASE_NAME = "FavoriteMovie";
    private static final String FAVO_TABLE = "MyFavoriteMovie";
    private static final String KEY_ID = "id";
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_MOVIE_NAME = "movie_name";
    private static final String KEY_MOVIE_IMG = "movie_img";
    private static final String KEY_MOVIE_POSTER = "movie_poster";
    private static final String KEY_MOVIE_RATE = "movie_rate";
    private static final String KEY_MOVIE_DATE = "movie_date";
    public MovieDatabaseHelper(Context context) {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FAVO_TABLE =  "CREATE TABLE "+FAVO_TABLE+" ("+KEY_ID+" INTEGER PRIMARY KEY,"+KEY_MOVIE_ID+" TEXT, "+KEY_MOVIE_NAME+" TEXT,"
                +KEY_MOVIE_IMG+" TEXT,"+KEY_MOVIE_POSTER+" TEXT,"+KEY_MOVIE_RATE+" TEXT,"+KEY_MOVIE_DATE+" TEXT)";
        db.execSQL(CREATE_FAVO_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+FAVO_TABLE);
        onCreate(db);
    }

    public void addMovieToFavorite(MovieDatabaseModel movieDatabaseModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOVIE_ID , movieDatabaseModel.getMovie_id());
        values.put(KEY_MOVIE_NAME , movieDatabaseModel.getMovie_name());
        values.put(KEY_MOVIE_IMG , movieDatabaseModel.getMovie_img());
        values.put(KEY_MOVIE_POSTER , movieDatabaseModel.getMovie_poster());
        values.put(KEY_MOVIE_RATE , movieDatabaseModel.getMovie_rate());
        values.put(KEY_MOVIE_DATE , movieDatabaseModel.getMovie_date());
        db.insert(FAVO_TABLE , null , values);
    }

    public boolean checkIsFilmFavorite(String movie_id){
        SQLiteDatabase sql = this.getWritableDatabase();
        String q = "SELECT * FROM " +FAVO_TABLE+" WHERE "+KEY_MOVIE_ID+" ='"+movie_id+"'";
        Cursor cursor = sql.rawQuery(q , null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public void deleteFromFavorite(String id)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ FAVO_TABLE + " WHERE "+KEY_MOVIE_ID+" ='"+id+"'");
        db.close();
    }
}
