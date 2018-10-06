package com.jsos.randomverse2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
//        setupAds();

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
        ImageView btnShare = (ImageView) findViewById(R.id.buttonShare);
        titleEngNIV.setText(R.string.NIV_title);
        titleFilMBB.setText(R.string.MBB_title);
        titleHeader.setText(BibleMCV1.versesQuery.get(verseId).name);
        contentEngNIV.setText(BibleMCV1.versesQuery.get(verseId).contentEnglish);
        contentFilMBB.setText(BibleMCV1.versesQuery.get(verseId).contentFilipino);

        /* SECTION: Button events */

        btnPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                verseId -= 1;
                if (verseId < 0) {
                    verseId = BibleMCV1.VERSE_COUNT;  // restart to lastW index
                }
                titleHeader.setText(BibleMCV1.versesQuery.get(verseId).name);
                contentEngNIV.setText(BibleMCV1.versesQuery.get(verseId).contentEnglish);
                contentFilMBB.setText(BibleMCV1.versesQuery.get(verseId).contentFilipino);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                verseId += 1;
                if (verseId > BibleMCV1.VERSE_COUNT) {
                    verseId = 0;  // restart to first index
                }
                titleHeader.setText(BibleMCV1.versesQuery.get(verseId).name);
                contentEngNIV.setText(BibleMCV1.versesQuery.get(verseId).contentEnglish);
                contentFilMBB.setText(BibleMCV1.versesQuery.get(verseId).contentFilipino);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");

                String shareBody = "NIV: \n" + BibleMCV1.versesQuery.get(verseId).contentEnglish;
                shareBody += "\n\nMBB: \n" + BibleMCV1.versesQuery.get(verseId).contentFilipino;
                shareBody += "\n\n" + BibleMCV1.versesQuery.get(verseId).name;

                shareBody += "\n\n via: https://play.google.com/store/apps/details?id=com.jsos.randomverse2";

                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        BibleMCV1.versesQuery.get(verseId).name);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }
}