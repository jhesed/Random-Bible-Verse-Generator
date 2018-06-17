package com.jsos.randomverse2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jsos.randomverse2.bible.BibleMCV1;

public class BibleMCDetailsActivity extends BaseRandomBibleVerse {
    private static final String TAG = "BibleMCDetailsActivity";
    private static int verseId;
    /**
     * VerseDetailsActivity.java: Displays details (i.e. NIV and MBB content)
     * of a specific Bible Verse
     */

    /* SECTION: Variable Declarations */

    private TextView titleHeader;
    private TextView contentEngNIV;
    private TextView contentFilMBB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_memorization_details);

        // Setup Ads
        setupAds();

        // Set icon in action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Retrieve view objects
        titleHeader = (TextView) findViewById(R.id.titleHeader);
        TextView titleEngNIV = (TextView) findViewById(R.id.titleEngNIV);
        TextView titleFilMBB = (TextView) findViewById(R.id.titleFilMBB);
        contentEngNIV = (TextView) findViewById(R.id.contentEngNIV);
        contentFilMBB = (TextView) findViewById(R.id.contentFilMBB);

        // Retrieve information passed from VerseListActivity class
        verseId = getIntent().getExtras().getInt("verseId");

        // Update views
        Button btnOk = (Button) findViewById(R.id.buttonOk);
        titleEngNIV.setText(R.string.NIV_title);
        titleFilMBB.setText(R.string.MBB_title);
        titleHeader.setText(BibleMCV1.versesQuery.get(verseId).name);
        contentEngNIV.setText(BibleMCV1.versesQuery.get(verseId).contentEnglish);
        contentFilMBB.setText(BibleMCV1.versesQuery.get(verseId).contentFilipino);

        /* SECTION: Button events */
        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BibleMCActivity.class);
                startActivity(intent);
            }
        });
    }
}