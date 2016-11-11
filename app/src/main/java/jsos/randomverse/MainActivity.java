package jsos.randomverse;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import jsos.randomverse.bible.BibleV1;

public class MainActivity extends AppCompatActivity {

    private Button btnRandom;
    private TextView titleHeader;
    private TextView titleEngNIV;
    private TextView titleFilMBB;
    private TextView contentEngNIV;
    private TextView contentFilMBB;

    private int lastVerseId = -1;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
//        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//    }
        BibleV1.generateQuery();

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

                // Generate random number
                // ---------- Try arraylist ------------
                int max = BibleV1.versesQuery.size();
                Random rand = new Random();
                int index = rand.nextInt(max);
                Log.d(TAG, "random number initial: " + index);

                // Do not use previous verse
                while (lastVerseId == index) {
                    index = rand.nextInt() + 1;
                }
                lastVerseId = index;

                titleHeader.setText(BibleV1.versesQuery.get(index).get(0).toString());
                titleEngNIV.setText("NIV");
                titleFilMBB.setText("MBB");
                contentEngNIV.setText(BibleV1.versesQuery.get(index).get(1).toString());
                contentFilMBB.setText(BibleV1.versesQuery.get(index).get(2).toString());
            }
        });
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
        builder.setView(inflater.inflate(R.layout.dialog_menu_about, null));

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
