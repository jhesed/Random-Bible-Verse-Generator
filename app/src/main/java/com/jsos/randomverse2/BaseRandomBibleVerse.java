package com.jsos.randomverse2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class BaseRandomBibleVerse extends AppCompatActivity {
    public static final String TAG = "Base";
    /**
     * Created by jhesed on 6/16/2018.
     * Base class which contains reusable code by other classes
     */

    /* SECTION: Variable Declarations */
    private AdView mAdView;
    private Menu menu;

    protected void setupAds() {

        /* SECTION: ADS */
        try {
            mAdView = (AdView) findViewById(R.id.adView);
            AdRequest.Builder adRequest = new AdRequest.Builder();
            adRequest.addTestDevice("E0672EF9205508F55913C27654ED0CE9");
            mAdView.loadAd(adRequest.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAboutDialog() {
        /*
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
        Button okButton = (Button) layout.findViewById(R.id.dialogOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
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
        menuHome.setVisible(true);
        menuList.setVisible(true);
        menuMemorizationChallange.setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* Adds behaviors to menu */
        int id = item.getItemId();

        if (id == R.id.menu_about) {
            // Shows information dialog
            showAboutDialog();
        } else if (id == R.id.menu_verse_list) {
            // Shows list of verses
            Intent intent = new Intent(this, VerseListActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_memorization_challenge) {
            // Shows Bible Memorization page
            Intent intent = new Intent(this, BibleMCActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_home) {
            // Shows information dialog
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


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
