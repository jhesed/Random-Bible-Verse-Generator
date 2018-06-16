package com.jsos.randomverse2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jsos.randomverse2.bible.BibleMemorizationChallenge;

public class BibleMemorizationChallengeDetailsActivity extends BaseRandomBibleVerse {
    private static final String TAG = "VerseDetailsActivity";
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
        setContentView(R.layout.activity_verse_details);

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
        Button btnPrev = (Button) findViewById(R.id.buttonPrev);
        Button btnNext = (Button) findViewById(R.id.buttonNext);
        titleEngNIV.setText(R.string.NIV_title);
        titleFilMBB.setText(R.string.MBB_title);
        titleHeader.setText(BibleMemorizationChallenge.versesQuery.get(verseId).name);
        contentEngNIV.setText(BibleMemorizationChallenge.versesQuery.get(verseId).contentEnglish);
        contentFilMBB.setText(BibleMemorizationChallenge.versesQuery.get(verseId).contentFilipino);

        /* SECTION: Button events */
        btnPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                verseId -= 1;
                if (verseId < 0) {
                    verseId = BibleMemorizationChallenge.VERSE_COUNT;  // restart to lastW index
                }
                titleHeader.setText(BibleMemorizationChallenge.versesQuery.get(verseId).name);
                contentEngNIV.setText(BibleMemorizationChallenge.versesQuery.get(verseId).contentEnglish);
                contentFilMBB.setText(BibleMemorizationChallenge.versesQuery.get(verseId).contentFilipino);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                verseId += 1;
                if (verseId > BibleMemorizationChallenge.VERSE_COUNT) {
                    verseId = 0;  // restart to first index
                }
                titleHeader.setText(BibleMemorizationChallenge.versesQuery.get(verseId).name);
                contentEngNIV.setText(BibleMemorizationChallenge.versesQuery.get(verseId).contentEnglish);
                contentFilMBB.setText(BibleMemorizationChallenge.versesQuery.get(verseId).contentFilipino);
            }
        });
    }
}