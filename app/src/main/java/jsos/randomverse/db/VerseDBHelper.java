package jsos.randomverse.db;

/**
 * Created by JHESE154 on 8/6/2016.
 */

//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//
//import jsos.randomverse.bible.BibleV1;
//import jsos.randomverse.db.VerseContract;
//
//public class VerseDBHelper extends SQLiteOpenHelper {
//
//    final String TAG = "VerseDbHelper";
//
//    public VerseDBHelper(Context context) {
//        super(context, VerseContract.DB_NAME, null, VerseContract.DB_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        String createTable = "CREATE TABLE " + VerseContract.VerseEntry.TABLE + " ( " +
//
//                VerseContract.VerseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//
//                VerseContract.VerseEntry.COL_NAME + " TEXT NOT NULL, " +
//                VerseContract.VerseEntry.COL_CONTENT_ENG_NIV + " TEXT DEFAULT NULL, " +
//                VerseContract.VerseEntry.COL_CONTENT_FIL_MB + " TEXT DEFAULT NULL, " +
//                VerseContract.VerseEntry.COL_IS_FAVORITE + " INTEGER DEFAULT 0, " +
//                VerseContract.VerseEntry.COL_DATE_CREATED + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
//                VerseContract.VerseEntry.COL_DATE_MODIFIED + " TIMESTAMP DEFAULT NULL, " +
////                VerseContract.VerseEntry.COL_DATE_MODIFIED + " TIMESTAMP DEFAULT NULL " +
//                "UNIQUE(" + VerseContract.VerseEntry.COL_NAME + "));";
//
//        Log.d(TAG, createTable);
//        db.execSQL(createTable);
//
//        // Initialize class
//        ArrayList<String> sqlQueries = BibleV1.generateQuery();
//        for(int i=0; i<sqlQueries.size(); i++) {
//            Log.d(TAG, sqlQueries.get(i));
//            db.rawQuery(sqlQueries.get(i), null);
//        }
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + VerseContract.VerseEntry.TABLE);
//        onCreate(db);
//    }

//}
