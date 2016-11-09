package jsos.randomverse;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import jsos.randomverse.bible.BibleV1;
import jsos.randomverse.db.VerseContract;
//import jsos.randomverse.db.VerseDBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnRandom;
    private TextView titleHeader;
    private TextView titleEngNIV;
    private TextView titleFilMBB;
    private TextView contentEngNIV;
    private TextView contentFilMBB;

//    private VerseDBHelper dbHelper;
    private int lastVerseId = -1;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BibleV1.generateQuery();

//        dbHelper = new VerseDBHelper(this);

        // Sets Random Button
        btnRandom = (Button) findViewById(R.id.buttonRandom) ;
        btnRandom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Random Button");

                // Get ids
                titleHeader = (TextView) findViewById(R.id.titleHeader);
                titleEngNIV = (TextView) findViewById(R.id.titleEngNIV);
                titleFilMBB = (TextView) findViewById(R.id.titleFilMBB);
                contentEngNIV = (TextView) findViewById(R.id.contentEngNIV);
                contentFilMBB = (TextView) findViewById(R.id.contentFilMBB);

                // Count SQL Entries
                // String query = "SELECT COUNT(*) FROM " + VerseContract.VerseEntry.TABLE + ";";
                // Log.d(TAG, query);
//                SQLiteDatabase db = dbHelper.getReadableDatabase();
//                int max = VerseContract.VERSE_COUNT;
//                 Cursor cursor = db.rawQuery(query, null);
//                 int max = cursor.getCount();
//                long max  = DatabaseUtils.queryNumEntries(
//                     db, VerseContract.VerseEntry.TABLE);
//                     db, VerseContract.DB_NAME);
//                int max = 27;  // TEST HARDCODED!!!!
//                Log.d(TAG, "Verse Count: " + max);

                // Generate random number
                // ---------- Try arraylist ------------
                int max = BibleV1.versesQuery.size();
                Random rand = new Random();
                int index = rand.nextInt(max);
                Log.d(TAG, "random number initial: " + index);
                // Do not use previous verse
                while (lastVerseId == index) {
                    index = rand.nextInt() + 1;
                    Log.d(TAG, "random number: " + index);
                }
                lastVerseId = index;

//                Log.d(TAG, "======== " + BibleV1.versesQuery.get(index).get(0));
                titleHeader.setText(BibleV1.versesQuery.get(index).get(0).toString());
                titleEngNIV.setText("NIV");
                titleFilMBB.setText("MBB");
                contentEngNIV.setText(BibleV1.versesQuery.get(index).get(1).toString());
                contentFilMBB.setText(BibleV1.versesQuery.get(index).get(2).toString());


                // Retrieve new content from database and update content
//                String query = "SELECT * FROM " + VerseContract.VerseEntry.TABLE + " WHERE " +
//                        VerseContract.VerseEntry._ID + " = "+ index + ";";
//                Log.d(TAG, query);
//                Cursor cursor = db.rawQuery(query, null);
//                cursor.moveToNext();
//                String header = cursor.getString(cursor.getColumnIndex(VerseContract.VerseEntry.COL_NAME));
//                Log.d(TAG, "HEADER: " + header);

//                titleHeader.setText(cursor.getString(cursor.getColumnIndex(VerseContract.VerseEntry.COL_NAME)));
//                titleEngNIV.setText("NIV");
//                titleFilMBB.setText("MBB");
//                contentEngNIV.setText(cursor.getString(cursor.getColumnIndex(VerseContract.VerseEntry.COL_CONTENT_ENG_NIV)));
//                contentFilMBB.setText(cursor.getString(cursor.getColumnIndex(VerseContract.VerseEntry.COL_CONTENT_FIL_MB)));

                // Close database connection
//                cursor.close();
//                db.close();
            }
        });
    }


}
