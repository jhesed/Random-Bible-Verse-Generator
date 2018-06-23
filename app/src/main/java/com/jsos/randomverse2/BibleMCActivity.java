/***
 * VerseDetailsActivity.java: Displays list of Bible Verses
 * @Author: Jhesed Tacadena
 * @Date: December 2016
 * */

package com.jsos.randomverse2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.ListView;

import com.jsos.randomverse2.adapters.BibleMCVerseAdapter;
import com.jsos.randomverse2.bible.BibleMCV1;

public class BibleMCActivity extends BaseRandomBibleVerse {

    /* SECTION: Variable Initializations */

    private static final String TAG = "BibleMCV1";
    public static Context contextOfApplication;
    public static SharedPreferences.Editor prefsEditor;
    SharedPreferences prefs;
    private ListView verseListView;
    private BibleMCVerseAdapter vAdapter;
    private Menu menu;

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }

    public static SharedPreferences.Editor getActivitySharedPreferencesEditor() {
        return prefsEditor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorization_verse_list);

        contextOfApplication = getApplicationContext();

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

            // Restore state of checked verses

            prefs = PreferenceManager.getDefaultSharedPreferences(this);
            prefsEditor = prefs.edit();
            String currentlyStored = prefs.getString("checkbox_states", null);
            int[] savedStatuses = null;
            if (currentlyStored != null) {
                String[] tmp = currentlyStored.split(",");
                savedStatuses = new int[tmp.length];
                for (int i = 0; i < tmp.length; i++) {
                    savedStatuses[i] = Integer.parseInt(tmp[i]);
                }
            }
            vAdapter = new BibleMCVerseAdapter(this, BibleMCV1.versesQuery, savedStatuses);
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