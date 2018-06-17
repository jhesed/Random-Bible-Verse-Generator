package com.jsos.randomverse2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jsos.randomverse2.bible.BibleV1;

import java.util.Random;

public class MainActivity extends BaseRandomBibleVerse {
    public static final String TAG = "MainActivity";
    /**
     * MainActivity.java: Displays the Main page for randomizing Bible verses
     */


    /* SECTION:  Variable Declarations */

    private TextView titleHeader;
    private TextView titleEngNIV;
    private TextView titleFilMBB;
    private TextView contentEngNIV;
    private TextView contentFilMBB;
    private int lastVerseId = -1;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup ads
        setupAds();

        // Set icon in action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Generate the Bible Verses
        BibleV1.generateQuery();

        // Sets Random Button
        Button btnRandom = (Button) findViewById(R.id.buttonRandom);

        /* SECTION: Events */

        btnRandom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Get View Ids
                titleHeader = (TextView) findViewById(R.id.titleHeader);
                titleEngNIV = (TextView) findViewById(R.id.titleEngNIV);
                titleFilMBB = (TextView) findViewById(R.id.titleFilMBB);
                contentEngNIV = (TextView) findViewById(R.id.contentEngNIV);
                contentFilMBB = (TextView) findViewById(R.id.contentFilMBB);

                // Generate random number for random Bible verse
                Random rand = new Random();
                int index = rand.nextInt(BibleV1.VERSE_COUNT);

                // Do not use previous verse
                while (lastVerseId == index) {
                    index = rand.nextInt(BibleV1.VERSE_COUNT);
                }
                lastVerseId = index;

                // Update the view with the new Bible Verse
                titleEngNIV.setText(R.string.NIV_title);
                titleFilMBB.setText(R.string.MBB_title);
                titleHeader.setText(BibleV1.versesQuery.get(index).name);
                contentEngNIV.setText(BibleV1.versesQuery.get(index).contentEnglish);
                contentFilMBB.setText(BibleV1.versesQuery.get(index).contentFilipino);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        this.menu = menu;

        // Update the menu
        invalidateOptionsMenu();
        MenuItem menuHome = menu.findItem(R.id.menu_home);
        MenuItem menuList = menu.findItem(R.id.menu_verse_list);
        MenuItem menuMemorizationChallange = menu.findItem(R.id.menu_memorization_challenge);
        menuHome.setVisible(false);
        menuList.setVisible(true);
        menuMemorizationChallange.setVisible(true);
        return true;
    }
}