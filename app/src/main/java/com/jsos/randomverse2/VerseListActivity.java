/***
 * VerseDetailsActivity.java: Displays list of Bible Verses
 * @Author: Jhesed Tacadena
 * @Date: December 2016
 * */

package com.jsos.randomverse2;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.jsos.randomverse2.adapters.VerseAdapter;
import com.jsos.randomverse2.bible.BibleV1;

public class VerseListActivity extends BaseRandomBibleVerse {

    /* SECTION: Variable Initializations */

    private static final String TAG = "VerseListActivity";
    private ListView verseListView;
    private VerseAdapter vAdapter;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verse_list);

        // Setup Ads
//        setupAds();

        // Set icon in action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        verseListView = (ListView) findViewById(R.id.verseList);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter
        if (vAdapter == null) {
            vAdapter = new VerseAdapter(this, BibleV1.versesQuery);
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