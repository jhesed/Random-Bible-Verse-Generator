/***
 * VerseDetailsActivity.java: Displays list of Bible Verses
 * @Author: Jhesed Tacadena
 * @Date: December 2016
 * */

package com.jsos.randomverse2;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.jsos.randomverse2.adapters.BibleMCVerseAdapter;
import com.jsos.randomverse2.bible.BibleMCV1;

public class BibleMCActivity extends BaseRandomBibleVerse {

    /* SECTION: Variable Initializations */

    private static final String TAG = "BibleMCV1";
    private ListView verseListView;
    private BibleMCVerseAdapter vAdapter;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorization_verse_list);

        // Setup Ads
        setupAds();

        // Set icon in action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Generate Bible Verses
        BibleMCV1.generateQuery();

        verseListView = (ListView) findViewById(R.id.verseList);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter
        if (vAdapter == null) {
            vAdapter = new BibleMCVerseAdapter(this, BibleMCV1.versesQuery);
            verseListView.setAdapter(vAdapter);
        }
//        else {
//            Log.d(TAG, "vAdapter not Null, refreshing");
//            vAdapter.clear();
//            vAdapter.addAll(BibleV1.versesQuery);
//            vAdapter.notifyDataSetChanged();
//        }
        verseListView.setAdapter(vAdapter);
    }
}