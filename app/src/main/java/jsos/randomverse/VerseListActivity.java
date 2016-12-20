package jsos.randomverse;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

import jsos.randomverse.bible.BibleV1;
import jsos.randomverse.models.Verse;

public class VerseListActivity extends AppCompatActivity {

    private Button btnRandom;
    private ListView verseListView;
    public static final String TAG = "VerseListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7520090340599763/9094681938");
//        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//    }
        // ================== ADS ====================

        try {
            mAdView = (AdView) findViewById(R.id.adView);
//            mAdView.setAdUnitId("ca-app-pub-7520090340599763/9094681938");
            AdRequest.Builder adRequest = new AdRequest.Builder();
            adRequest.addTestDevice("E0672EF9205508F55913C27654ED0CE9");
            //                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            //                // Check the LogCat to get your test device ID
            //                .addTestDevice("C04B1BFFB0774708339BC273F8A43708")
            mAdView.loadAd(adRequest.build());
        } catch(Exception e) {
            e.printStackTrace();
        }

        BibleV1.generateQuery();

        setContentView(R.layout.content_verse_list);
        verseListView = (ListView) findViewById(R.id.verseList);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<Verse> arrayAdapter = new ArrayAdapter<Verse>(
                this,
                android.R.layout.simple_list_item_1,
                BibleV1.versesQuery);

        verseListView.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* Adds behaviors to menu */
        int id = item.getItemId();

        if (id == R.id.menu_about) {
            // Shows information dialog
            showAboutDialog();
        }
        if (id == R.id.menu_verse_list) {
            // Shows information dialog
            Intent intent = new Intent(this, VerseDetailsActivity.class);
            this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    private void showAboutDialog() {
        /**
         Displays dialog box of developer information
         */

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View layout = inflater.inflate(R.layout.dialog_menu_about, null);
        builder.setView(layout);
        //        builder.setNegativeButton("OK", null);
        final AlertDialog dialog = builder.create();

        // close dialog box on click
        Button okButton = (Button)layout.findViewById(R.id.dialogOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    /************************* ADS ******************************/

    private AdView mAdView;
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
