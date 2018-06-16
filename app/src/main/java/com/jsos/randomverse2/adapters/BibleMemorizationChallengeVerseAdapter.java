/***
 * VerseAdapter.java: A custom adapter for creating Verse list views
 * @Author: Jhesed Tacadena
 * @Date: November 2016
 * */

package com.jsos.randomverse2.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jsos.randomverse2.BibleMemorizationChallengeDetailsActivity;
import com.jsos.randomverse2.R;
import com.jsos.randomverse2.models.Verse;

import java.util.ArrayList;

public class BibleMemorizationChallengeVerseAdapter extends ArrayAdapter<Verse> {

    /* SECTION: Variable Declarations */

    private final String TAG = "BibleMemorizationListAdapter";
    private final Context context;
    private final ArrayList<Verse> verse;
    private ViewHolder viewHolder;

    public BibleMemorizationChallengeVerseAdapter(Context context, ArrayList<Verse> verse) {
        super(context, R.layout.activity_bible_memorization_verse_list, verse);
        this.context = context;
        this.verse = verse;
        viewHolder = new ViewHolder();
    }

    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        /*
         * Overrides parent for retrieving view
         * */

        Verse verse = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_bible_memorization_verse_list, null, true);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Lookup view for data population
        viewHolder.verseId = verse.id;
        viewHolder.verseName = (TextView) view.findViewById(R.id.verseItem);

        // Populate the data into the template view using the data object
        viewHolder.verseName.setText(verse.name);
        // viewHolder.verseContent.setText(verse.content);

        view.setTag(viewHolder);
        view.setLongClickable(true);

        /* SECTION : Events */

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BibleMemorizationChallengeDetailsActivity.class);
                intent.putExtra("verseId", viewHolder.verseId);
                context.startActivity(intent);
            }
        });
        return view;
    }

    private static class ViewHolder {
        /**
         * Private class for recyclable information
         */
        int verseId;
        TextView verseName;
        // TextView verseContent;
    }
}