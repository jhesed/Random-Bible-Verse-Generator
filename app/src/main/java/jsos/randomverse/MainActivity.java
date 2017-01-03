/***
* MainActivity.java: Displays the Main page for randomizing Bible verses
* @Author: Jhesed Tacadena
* @Date: November 2016
* */

package jsos.randomverse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

import jsos.randomverse.bible.BibleV1;

public class MainActivity extends AppCompatActivity {

    /* SECTION:  Variable Declarations */

    private Button btnRandom;
    private TextView titleHeader;
    private TextView titleEngNIV;
    private TextView titleFilMBB;
    private TextView contentEngNIV;
    private TextView contentFilMBB;
    private Menu menu;
    private int lastVerseId = -1;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* SECTION: ADS */

        try {
            mAdView = (AdView) findViewById(R.id.adView);
            AdRequest.Builder adRequest = new AdRequest.Builder();
            adRequest.addTestDevice("E0672EF9205508F55913C27654ED0CE9");
            mAdView.loadAd(adRequest.build());
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Set icon in action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Generate the Bible Verses
        BibleV1.generateQuery();

        // Sets Random Button
        btnRandom = (Button) findViewById(R.id.buttonRandom) ;

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
        menuHome.setVisible(false);
        menuList.setVisible(true);

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
        else if (id == R.id.menu_verse_list) {
            // Shows information dialog
            Intent intent = new Intent(this, VerseListActivity.class);
            startActivity(intent);
            return true;
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